package ir.paasaan.service;

import ir.paasaan.dto.CustomerPaymentStatus;
import ir.paasaan.dto.PaymentInfo;
import ir.paasaan.persistence.entity.Payment;
import ir.paasaan.persistence.entity.PaymentStatus;

/**
 * @author arman
 * @since 11/27/2015.
 */
public class Assembler {
    public static PaymentStatus convertToStatus(CustomerPaymentStatus paymentStatus) {
        if (paymentStatus == null) {
            return PaymentStatus.DONE;
        }
        switch (paymentStatus) {
            case DONE:
                return PaymentStatus.DONE;
            case PENDING:
                return PaymentStatus.PENDING;
            case EXPIRED:
                return PaymentStatus.EXPIRED;
            default:
                return PaymentStatus.DONE;
        }
    }

    public static PaymentInfo convertToPaymentInfo(Payment payment) {
        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setPaymentDate(payment.getPaymentDate());
        paymentInfo.setAmount(payment.getAmount());
        paymentInfo.setCustomerName(payment.getCustomer().getName());
        paymentInfo.setPaymentId(payment.getGeneratedPaymentId());
        paymentInfo.setPaymentDate(payment.getPaymentDate());
        return paymentInfo;
    }
}
