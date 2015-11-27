package ir.paasaan.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author arman
 * @since 11/27/2015.
 */
public class SearchPaymentResponse {
    private String paymentId;
    private BigDecimal amount;
    private Date paymentDate;
    private String customerName;
    private CustomerPaymentStatus paymentStatus;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public CustomerPaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(CustomerPaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
