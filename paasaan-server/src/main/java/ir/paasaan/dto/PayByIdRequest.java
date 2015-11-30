package ir.paasaan.dto;

/**
 * @author arman
 * @since 11/27/2015.
 */
public class PayByIdRequest extends CustomerBaseRequest {
    private String paymentId;
    private int score;
    private String comment;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "PayByIdRequest{" +
                "paymentId='" + paymentId + '\'' +
                "} " + super.toString();
    }
}
