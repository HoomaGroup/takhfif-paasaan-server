package ir.paasaan.persistence.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Boshra Taheri
 * @since 11/25/2015
 */
@Entity
@Table(name = "CUSTOMER")
@PrimaryKeyJoinColumn(name="USER_ID")
public class Customer extends User {
    @Column(name = "CREDIT")
    private BigDecimal credit;
    @Column(name = "SCORE")
    private long score;

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }
}
