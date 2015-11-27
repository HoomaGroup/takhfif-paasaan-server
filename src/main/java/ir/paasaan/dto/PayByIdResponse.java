package ir.paasaan.dto;

/**
 * @author arman
 * @since 11/27/2015.
 */
public class PayByIdResponse {
    private String referenceId;

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    @Override
    public String toString() {
        return "PayByIdResponse{" +
                "referenceId='" + referenceId + '\'' +
                '}';
    }
}
