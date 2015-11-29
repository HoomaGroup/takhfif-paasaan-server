package ir.paasaan.service;

import ir.paasaan.dto.*;
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
            return null;
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

    public static SearchDiscountResponse convertToDiscountResponse(List<Discount> discounts, SearchDiscountRequest request) {
        SearchDiscountResponse response = new SearchDiscountResponse();
        if (discounts == null) {
            return response;
        }


        for (Discount discount : discounts) {
            double distance =
                    distFrom(request.getLatitude(), request.getLongitude(),
                            discount.getMerchant().getLatitude(), discount.getMerchant().getLongitude());
            if (distance <= request.getDistanceLessThan().doubleValue()) {
                MerchantInfoResponse merchantInfoResponse = new MerchantInfoResponse();
                merchantInfoResponse.setDescription(discount.getDescription());
                merchantInfoResponse.setMerchantId(String.valueOf(discount.getMerchant().getId()));
                merchantInfoResponse.setDiscount(discount.getCustomerDiscountPercentage());
                merchantInfoResponse.setDistance(Math.round(distance));
                merchantInfoResponse.setGroupName(discount.getMerchant().getName());
                merchantInfoResponse.setLatitude(discount.getMerchant().getLatitude());
                merchantInfoResponse.setLongitude(discount.getMerchant().getLongitude());
                merchantInfoResponse.setTags(Assembler.ConvertToTag(discount.getTags()));
                response.getMerchantInfos().add(merchantInfoResponse);
            }
        }
        return response;
    }

    private static List<String> ConvertToTag(List<Tag> tags) {
        List<String> result = new ArrayList<>();
        if (tags == null) {
            return result;
        }
        for (Tag tag : tags) {
            result.add(tag.getTag());
        }
        return result;
    }

    public static double distFrom(double lat1, double lng1, double lat2, double lng2) {
        double earthRadius = 6371000; //meters
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return earthRadius * c;
    }
}
