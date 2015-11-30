package ir.paasaan.invoker.dto;

import java.util.List;

/**
 * @author Boshra Taheri
 * @since 11/27/2015
 */
public class AccountShortStatementResponse extends ResponseBase {

    private List<ShortStatementRecord> additionalData;

    public List<ShortStatementRecord> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(List<ShortStatementRecord> additionalData) {
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
