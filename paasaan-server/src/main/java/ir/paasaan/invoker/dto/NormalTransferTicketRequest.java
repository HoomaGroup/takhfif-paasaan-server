package ir.paasaan.invoker.dto;

import java.math.BigDecimal;

/**
 * @author Boshra Taheri
 * @since 11/27/2015
 */
public class NormalTransferTicketRequest extends RequestBase {
    private String accountNo;
    private String destination;
    private BigDecimal amount;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "NormalTransferTicketRequest{" +
                "accountNo='" + accountNo + '\'' +
                ", destination='" + destination + '\'' +
                ", amount=" + amount +
                '}';
    }
}
