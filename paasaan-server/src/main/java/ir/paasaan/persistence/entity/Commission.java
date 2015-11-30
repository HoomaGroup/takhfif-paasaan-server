package ir.paasaan.persistence.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Boshra Taheri
 * @since 11/26/2015
 */
@Entity
@Table(name = "COMMISSION")
public class Commission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TRANSACTION_DATE")
    private Date transactionDate;
    @Column(name = "SETTLEMENT_DATE")
    private Date settlementDate;
    @Column(name = "AMOUNT")
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private CommissionStatus status;
    @Column(name = "SETTLEMENT_DEPOSIT")
    private String settlementDeposit;
    @ManyToOne
    @JoinColumn(name = "PAYMENT_ID")
    private Payment payment;
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private CommissionType type;
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public CommissionStatus getStatus() {
        return status;
    }

    public void setStatus(CommissionStatus status) {
        this.status = status;
    }

    public String getSettlementDeposit() {
        return settlementDeposit;
    }

    public void setSettlementDeposit(String settlementDeposit) {
        this.settlementDeposit = settlementDeposit;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public CommissionType getType() {
        return type;
    }

    public void setType(CommissionType type) {
        this.type = type;
    }
}
