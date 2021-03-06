package ir.paasaan.invoker.dto;

/**
 * @author Boshra Taheri
 * @since 11/27/2015
 */
public class AchTransferTicketResponse extends ResponseBase {

    private TxnTicket additionalData;

    public TxnTicket getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(TxnTicket additionalData) {
        this.additionalData = additionalData;
    }

    @Override
    public String toString() {
        return "AchTransferTicketResponse{" +
                "resultCode=" + resultCode +
                ", accountNo='" + accountNo + '\'' +
                ", amount=" + amount +
                ", additionalData='" + additionalData + '\'' +
                '}';
    }
}
