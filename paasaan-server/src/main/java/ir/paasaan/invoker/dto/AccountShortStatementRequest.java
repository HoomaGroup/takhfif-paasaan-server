package ir.paasaan.invoker.dto;

/**
 * @author Boshra Taheri
 * @since 11/27/2015
 */
public class AccountShortStatementRequest extends RequestBase{
    private String accountNumber;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "AccountBalanceRequest{" +
                "accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
