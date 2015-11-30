package ir.paasaan.invoker.dto;

/**
 * @author Boshra Taheri
 * @since 11/27/2015
 */
public class AccountBalanceResponse extends ResponseBase{


    private String additionalData;

    public String getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(String additionalData) {
        this.additionalData = additionalData;
    }

    @Override
    public String toString() {
        return "AccountBalanceResponse{" +
                "resultCode=" + resultCode +
                ", accountNo='" + accountNo + '\'' +
                ", amount=" + amount +
                ", additionalData='" + additionalData + '\'' +
                '}';
    }
}
