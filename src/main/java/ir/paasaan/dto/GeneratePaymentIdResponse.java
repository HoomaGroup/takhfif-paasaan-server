package ir.paasaan.dto;

/**
 * @author Boshra Taheri
 * @since 11/15/2015
 */
public class GeneratePaymentIdResponse {
    private String paymentId;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    @Override
    public String toString() {
        return "GeneratePaymentIdResponse{" +
                "paymentId='" + paymentId + '\'' +
                '}';
    }
}
