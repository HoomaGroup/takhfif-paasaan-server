package ir.paasaan.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author arman
 * @since 11/27/2015.
 */
public class SearchPaymentResponse {
   private List<PaymentInfo> paymentInfos = new ArrayList<PaymentInfo>();

    public List<PaymentInfo> getPaymentInfos() {
        return paymentInfos;
    }

    public void setPaymentInfos(List<PaymentInfo> paymentInfos) {
        this.paymentInfos = paymentInfos;
    }

    @Override
    public String toString() {
        return "SearchPaymentResponse{" +
                "paymentInfos=" + paymentInfos +
                '}';
    }
}
