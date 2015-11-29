package ir.paasaan.invoker.dto;

import java.math.BigDecimal;

/**
 * @author Boshra Taheri
 * @since 11/29/2015
 */
public class TransferReceipt {
    private String date;
    private String time;
    private String destinationAccount;
    private BigDecimal amount;
    private String traceNo;
    private String name;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TransferReceipt{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", destinationAccount='" + destinationAccount + '\'' +
                ", amount=" + amount +
                ", traceNo='" + traceNo + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
