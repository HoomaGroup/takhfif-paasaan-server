package ir.paasaan.dto;

/**
 * @author arman
 * @since 11/27/2015.
 */
public class SearchPaymentRequest {
    private String merchantId;
    private String paymentId;
    private CustomerPaymentStatus paymentStatus;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public CustomerPaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(CustomerPaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "SearchPaymentRequest{" +
                "merchantId='" + merchantId + '\'' +
                ", paymentId='" + paymentId + '\'' +
                ", paymentStatus=" + paymentStatus +
                '}';
    }
}
