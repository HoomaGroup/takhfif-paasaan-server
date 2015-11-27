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
        String queryStr = " from Discount d where 1=1 ";
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

        }
        if (tags != null) {

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

        }
        if (tags != null) {

        }
        return (List<Discount>) query.list();
    }
}
