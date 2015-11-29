package ir.paasaan.invoker.dto;

/**
 * @author Boshra Taheri
 * @since 11/27/2015
 */
public class AchTransferResponse extends ResponseBase {

    private TransferReceipt additionalData;

    public TransferReceipt getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(TransferReceipt additionalData) {
        this.additionalData = additionalData;
    }

    @Override
    public String toString() {
        return "NormalTransferResponse{" +
                "resultCode=" + resultCode +
                ", accountNo='" + accountNo + '\'' +
                ", amount=" + amount +
                ", additionalData='" + additionalData + '\'' +
                '}';
    }
}
