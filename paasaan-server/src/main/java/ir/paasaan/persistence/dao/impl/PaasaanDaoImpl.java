package ir.paasaan.persistence.dao.impl;

import ir.paasaan.persistence.dao.PaasaanDao;
import ir.paasaan.persistence.dao.exception.DaoRuntimeException;
import ir.paasaan.persistence.dao.exception.EntityAlreadyExistsException;
import ir.paasaan.persistence.entity.BaseEntity;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Boshra Taheri
 * @since 11/26/2015
 */
public abstract class PaasaanDaoImpl<T extends BaseEntity, Id extends Serializable>
        extends HibernateDaoSupport implements PaasaanDao<T, Id> {

    private Class<T> type;

    protected Session getCurrentSession() {
        return getHibernateTemplate().getSessionFactory().getCurrentSession();
    }

    @SuppressWarnings({"unchecked"})
    public PaasaanDaoImpl() {
        Class genericClass = getClass();
        Type genericType = genericClass.getGenericSuperclass();
        while (!(genericType instanceof ParameterizedType)) {
            genericClass = genericClass.getSuperclass();
            if (genericClass == null) {
                throw new RuntimeException("class is not generic");
            }
            genericType = genericClass.getGenericSuperclass();
        }
        this.type = (Class<T>) ((ParameterizedType) (genericType)).getActualTypeArguments()[0];
    }

    @Override
    public T save(T entity) {
        entity = doPersist(entity);
        getHibernateTemplate().flush();
        return entity;
    }

    @Override
    public List<T> save(List<T> entities) {
        List<T> mergedEntities = new ArrayList<T>();
        for (T t : entities) {
            mergedEntities.add(doMerge(t));
            getHibernateTemplate().flush();
        }
        return mergedEntities;
    }

    @Override
    public T saveOrUpdate(T entity) {
        if (entity != null) {
            BaseEntity cme = entity;
            T attachedEntity;
            if (cme.getId() == null) {
                entity = doPersist(entity);
                attachedEntity = entity;
            } else {
                attachedEntity = doMerge(entity);
            }
            getHibernateTemplate().flush();
            return attachedEntity;
        } else {
            throw new DaoRuntimeException("entity is not instance of HoomaEntity");
        }
    }

    @Override
    public T edit(T entity) {
        entity = doMerge(entity);
        getHibernateTemplate().flush();
        return entity;
    }

    @Override
    public void delete(Id id) {
        String query = "delete from " + type.getSimpleName() + " e where e.id = ?";
        //remove cached objects from persistence context.
        getHibernateTemplate().flush();
        getHibernateTemplate().clear();
        getCurrentSession().createQuery(query).setParameter(0, id).executeUpdate();
    }

    @Override
    public void delete(T entity) {
        if (!getHibernateTemplate().contains(entity)) {
            entity = doMerge(entity);
        }
        try {
            doDelete(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(List<T> entities) {
        if (entities == null) {
            return;
        }
        try {
            for (T entry : entities) {
                doDelete(entry);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public T get(Id id) {
        return getHibernateTemplate().get(type, id);
    }

    @Override
    public List<T> getAll() {
        return getHibernateTemplate().loadAll(type);
    }

    private T doPersist(T entity) {
        try {
            getHibernateTemplate().persist(entity);
            return entity;
        } catch (javax.persistence.EntityExistsException e) {
            throw new EntityAlreadyExistsException("entity '" + entity.getClass().getName() + "' already persisted: "
                    + entity.toString());
        }
    }

    private T doMerge(T entity) {
        return getHibernateTemplate().merge(entity);
    }

    private void doDelete(T entity) throws Exception {
        if (!getHibernateTemplate().contains(entity)) {
            entity = getHibernateTemplate().merge(entity);
        }
        getHibernateTemplate().delete(entity);
    }
}
