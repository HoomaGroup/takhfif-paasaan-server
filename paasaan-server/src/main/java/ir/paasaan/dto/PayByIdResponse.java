package ir.paasaan.dto;

/**
 * @author arman
 * @since 11/27/2015.
 */
public class PayByIdResponse {
    private String referenceId;
    private boolean success;

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

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
}
