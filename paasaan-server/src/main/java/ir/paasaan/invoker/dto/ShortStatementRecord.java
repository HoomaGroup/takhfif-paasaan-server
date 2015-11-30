package ir.paasaan.invoker.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Boshra Taheri
 * @since 11/27/2015
 */
public class ShortStatementRecord {
    private int number;
    private String description;
    private BigDecimal amount;
    private String date;
    private String time;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

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

    @Override
    public String toString() {
        return "ShortStatementRecord{" +
                "number=" + number +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
