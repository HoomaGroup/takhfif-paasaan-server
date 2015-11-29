package ir.paasaan.persistence.dao.impl;

import ir.paasaan.persistence.entity.Payment;
import ir.paasaan.persistence.entity.PaymentStatus;
import ir.paasaan.persistence.entity.Tag;
import org.hibernate.Query;

import java.util.List;

/**
 * @author Boshra Taheri
 * @since 11/26/2015
 */
public class PaymentDaoImpl extends PaasaanDaoImpl<Payment, Long> {
    public Payment getPaymentsInfo(String paymentId, PaymentStatus status) {
        String queryStr = "from Payment p where p.generatedPaymentId = :generatedPaymentId ";
        if(status != null){
            queryStr +=" and p.status= :status";
        }
        Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
        query.setParameter("generatedPaymentId", paymentId);
        if(status != null){
            query.setParameter("status", status);
        }
        return (Payment) query.uniqueResult();
    }
}
