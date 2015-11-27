package ir.paasaan.service;

import ir.paasaan.dto.CustomerPaymentStatus;
import ir.paasaan.dto.MerchantInfoResponse;
import ir.paasaan.dto.PaymentInfo;
import ir.paasaan.dto.SearchDiscountResponse;
import ir.paasaan.persistence.entity.Discount;
import ir.paasaan.persistence.entity.Payment;
import ir.paasaan.persistence.entity.PaymentStatus;
import ir.paasaan.persistence.entity.Tag;

import java.util.ArrayList;
import java.util.List;

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
        if (payment == null) {
            return paymentInfo;
        }
        paymentInfo.setPaymentDate(payment.getPaymentDate());
        paymentInfo.setAmount(payment.getAmount());
        paymentInfo.setCustomerName(payment.getCustomer().getName());
        paymentInfo.setPaymentId(payment.getGeneratedPaymentId());
        paymentInfo.setPaymentDate(payment.getPaymentDate());
        paymentInfo.setPaymentStatus(Assembler.convertToStatus(payment.getStatus()));
        return paymentInfo;
    }

    private static CustomerPaymentStatus convertToStatus(PaymentStatus status) {
        if (status == null) {
            return CustomerPaymentStatus.PENDING;
        }
        switch (status) {
            case DONE:
                return CustomerPaymentStatus.DONE;
            case PENDING:
                return CustomerPaymentStatus.PENDING;
            case EXPIRED:
                return CustomerPaymentStatus.EXPIRED;
            default:
                return CustomerPaymentStatus.PENDING;
        }
    }

    public static SearchDiscountResponse convertToDiscountResponse(List<Discount> discounts) {
        SearchDiscountResponse response = new SearchDiscountResponse();
        if(discounts == null){
         return response;
        }

        for (Discount discount : discounts) {
            MerchantInfoResponse merchantInfoResponse = new MerchantInfoResponse();
            merchantInfoResponse.setDescription("");//todo add description To model
            merchantInfoResponse.setMerchantId(String.valueOf(discount.getMerchant().getId()));
            merchantInfoResponse.setDiscount(discount.getCustomerDiscountPercentage());
            merchantInfoResponse.setDistance(0l);//todo must calculate distance
            merchantInfoResponse.setGroupName(discount.getMerchant().getName());
            merchantInfoResponse.setX(0d);//todo must calculate distance
            merchantInfoResponse.setY(0d);//todo must calculate distance
            merchantInfoResponse.setTags(Assembler.ConvertToTag(discount.getTags()));
            response.getMerchantInfos().add(merchantInfoResponse);
        }
        return response;
    }

    private static List<String> ConvertToTag(List<Tag> tags) {
        List<String> result = new ArrayList<>();
        if(tags == null){
            return result;
        }
        for (Tag tag : tags) {
            result.add(tag.getTag());
        }
        return result;
    }
}
