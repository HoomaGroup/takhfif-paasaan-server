package ir.paasaan.persistence.entity;

import javax.persistence.*;

/**
 * @author Boshra Taheri
 * @since 11/25/2015
 */
@Entity
@Table(name = "USER")
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "CIF", nullable = false, unique = true)
    private String cif;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "ACCESS_TOKEN", nullable = false, unique = true)
    private String accessToken;
    @Column(name = "REFRESH_TOKEN", nullable = false, unique = true)
    private String refreshToken;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
