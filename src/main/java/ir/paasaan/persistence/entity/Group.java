package ir.paasaan.persistence.entity;

import javax.persistence.*;

/**
 * @author Boshra Taheri
 * @since 11/26/2015
 */
@Entity
@Table(name = "GROUPS")
public class Group extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
