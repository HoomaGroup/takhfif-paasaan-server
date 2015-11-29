package ir.paasaan.persistence.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author Boshra Taheri
 * @since 11/26/2015
 */
@Entity
@Table(name = "TAG")
public class Tag extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TAG")
    private String tag;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

}
