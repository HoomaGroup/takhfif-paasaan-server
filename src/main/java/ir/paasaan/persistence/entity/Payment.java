package ir.paasaan.persistence.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Boshra Taheri
 * @since 11/26/2015
 */
@Entity
@Table(name = "PAYMENT")
public class Payment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "GENERATED_PAYMENT_ID")
    private String generatedPaymentId;
    @Column(name = "REFERENCE_NUMBER")
    private String referenceNumber;
    @Column(name = "CREATION_DATE")
    private Date creationDate;
    @Column(name = "PAYMENT_DATE")
    private Date paymentDate;
    @Column(name = "AMOUNT")
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private PaymentStatus status;
    @Column(name = "SCORE")
    private int score;
    @Lob
    @Column(name = "COMMENT")
    private String comment;
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private User customer;
    @ManyToOne
    @JoinColumn(name = "DISCOUNT_ID")
    private Discount discount;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getGeneratedPaymentId() {
        return generatedPaymentId;
    }

    public void setGeneratedPaymentId(String generatedPaymentId) {
        this.generatedPaymentId = generatedPaymentId;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
