package ir.paasaan.invoker.dto;

import java.math.BigDecimal;

/**
 * @author Boshra Taheri
 * @since 11/27/2015
 */
public class TxnTicket {
    private String ticket;
    private String srcAccount;
    private String destinationAccount;
    private BigDecimal amount;
    private String dateTime;
    private String name;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getSrcAccount() {
        return srcAccount;
    }

    public void setSrcAccount(String srcAccount) {
        this.srcAccount = srcAccount;
    }

    public String getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(String destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TxnTicket{" +
                "ticket='" + ticket + '\'' +
                ", srcAccount='" + srcAccount + '\'' +
                ", destinationAccount='" + destinationAccount + '\'' +
                ", amount=" + amount +
                ", dateTime='" + dateTime + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
