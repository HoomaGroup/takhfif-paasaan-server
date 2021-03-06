package ir.paasaan.persistence.dao.impl;

import ir.paasaan.persistence.entity.Payment;
import ir.paasaan.persistence.entity.PaymentStatus;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;

import java.util.List;

/**
 * @author Boshra Taheri
 * @since 11/26/2015
 */
public class PaymentDaoImpl extends PaasaanDaoImpl<Payment, Long> {
    public Payment getPaymentsInfo(String paymentId, PaymentStatus status) {
        String queryStr = "from Payment p where 1=1 ";
        if(paymentId != null){
            queryStr +=" and p.generatedPaymentId = :generatedPaymentId ";
        }
        if(status != null){
            queryStr +=" and p.status= :status";
        }
        Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
        if(paymentId != null) {
            query.setParameter("generatedPaymentId", paymentId);
        }
        if(status != null){
            query.setParameter("status", status);
        }
        return (Payment) query.uniqueResult();
    }

    public List<Payment> getPaymentsInfo(String paymentId, PaymentStatus status, String merchantId) {
        String queryStr = "from Payment p where 1=1 and p.discount.merchant.id = :merchantId ";
        if(StringUtils.isNotEmpty(paymentId)){
            queryStr +=" and p.generatedPaymentId = :generatedPaymentId ";
        }
        if(status != null){
            queryStr +=" and p.status= :status";
        }
        Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
        if(StringUtils.isNotEmpty(paymentId)){
            query.setParameter("generatedPaymentId", paymentId);
        }
        if(status != null){
            query.setParameter("status", status);
        }
        query.setParameter("merchantId", Long.valueOf(merchantId));
        return (List<Payment>) query.list();
    }
}
