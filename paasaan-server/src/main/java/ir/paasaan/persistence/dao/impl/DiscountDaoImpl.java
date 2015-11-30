package ir.paasaan.persistence.dao.impl;

import ir.paasaan.persistence.entity.Discount;
import org.hibernate.Query;

import java.util.List;

/**
 * @author Boshra Taheri
 * @since 11/26/2015
 */
public class DiscountDaoImpl extends PaasaanDaoImpl<Discount, Long> {
    public List<Discount> find(Long discountFrom, Long distanceLessThan, String groupName, String merchantName, List<String> tags) {
        String queryStr = " from Discount d ";
        if (tags != null) {
            queryStr += " join d.tags t";//conditional
        }

        queryStr += " where 1=1"; //where clause default

        if (discountFrom != null) {
            queryStr += " and  d.customerDiscountPercentage >= :customerDiscountPercentage ";
        }
        if (groupName != null) {
            queryStr += " and :groupName in  d.merchant.group ";
        }
        if (merchantName != null) {
            queryStr += " and d.merchant.name = :merchantName ";
        }
        if (distanceLessThan != null) {
            //todo search in database for better performance
        }
        if (tags != null) {
            for (int i = 0; i < tags.size(); i++) {
                String tag = tags.get(i);
                queryStr += " and t.tag = :tag" + i + " ";
            }
        }
        Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);

        if (discountFrom != null) {
            query.setParameter("customerDiscountPercentage", discountFrom);
        }
        if (groupName != null) {
            query.setParameter("groupName", groupName);
        }
        if (merchantName != null) {
            query.setParameter("merchantName", merchantName);
        }
        if (distanceLessThan != null) {
        //todo search in database for better performance
        }
        if (tags != null) {
            for (int i = 0; i < tags.size(); i++) {
                String tag = tags.get(i);
                query.setParameter("tag" + i, tag);
            }
        }
        return (List<Discount>) query.list();
    }
}
