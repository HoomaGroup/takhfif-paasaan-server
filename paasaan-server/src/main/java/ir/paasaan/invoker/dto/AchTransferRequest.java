package ir.paasaan.invoker.dto;

import java.math.BigDecimal;

/**
 * @author Boshra Taheri
 * @since 11/27/2015
 */
public class AchTransferRequest extends RequestBase {
    private String accountNo;
    private String destination;
    private BigDecimal amount;
    private String ticket;

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

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "AchTransferRequest{" +
                "accountNo='" + accountNo + '\'' +
                ", destination='" + destination + '\'' +
                ", amount=" + amount +
                ", ticket=" + ticket +
                '}';
    }
}
