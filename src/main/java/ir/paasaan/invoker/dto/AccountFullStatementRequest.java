package ir.paasaan.invoker.dto;

import java.util.Date;

/**
 * @author Boshra Taheri
 * @since 11/27/2015
 */
public class AccountFullStatementRequest extends RequestBase {
    private String accountNumber;
    private Date fromDate;
    private Date toDate;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }


}
