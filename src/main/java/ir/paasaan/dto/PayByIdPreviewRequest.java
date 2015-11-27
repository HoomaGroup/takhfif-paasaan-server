package ir.paasaan.dto;

/**
 * @author arman
 * @since 11/27/2015.
 */
public class PayByIdPreviewRequest {
    private String paymentId;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    @Override
    public String toString() {
        return "PayByIdPreviewRequest{" +
                "paymentId='" + paymentId + '\'' +
                '}';
    }
}
