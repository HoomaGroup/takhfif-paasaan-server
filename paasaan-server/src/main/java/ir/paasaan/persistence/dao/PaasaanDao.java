package ir.paasaan.persistence.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Boshra Taheri
 * @since 11/26/2015
 */
public interface PaasaanDao<T, Id extends Serializable> {
    T save(T entity);

    List<T> save(List<T> entities);

    T saveOrUpdate(T entity);

    T edit(T entity);

    void delete(Id id);

    void delete(T entity);

    void delete(List<T> entities);

    T get(Id id);

    List<T> getAll();
}
