package ir.paasaan.persistence.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author Boshra Taheri
 * @since 11/26/2015
 */
@Entity
@Table(name = "DISCOUNT")
public class Discount extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TOTAL_DISCOUNT_PERCENTAGE")
    private double totalDiscountPercentage;
    @Column(name = "CUSTOMER_DISCOUNT_PERCENTAGE")
    private double customerDiscountPercentage;
    @ManyToMany
    @JoinTable(name = "DISCOUNT_TAG")
    private List<Tag> tags;
    @Column(name = "REVIEWS_COUNT")
    private long reviewsCount;
    @Column(name = "AVERAGE_SCORE")
    private double averageScore;
    @ManyToOne
    @JoinColumn(name = "MERCHANT_ID")
    private Merchant merchant;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public double getTotalDiscountPercentage() {
        return totalDiscountPercentage;
    }

    public void setTotalDiscountPercentage(double totalDiscountPercentage) {
        this.totalDiscountPercentage = totalDiscountPercentage;
    }

    public double getCustomerDiscountPercentage() {
        return customerDiscountPercentage;
    }

    public void setCustomerDiscountPercentage(double customerDiscountPercentage) {
        this.customerDiscountPercentage = customerDiscountPercentage;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public long getReviewsCount() {
        return reviewsCount;
    }

    public void setReviewsCount(long reviewsCount) {
        this.reviewsCount = reviewsCount;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }
}
