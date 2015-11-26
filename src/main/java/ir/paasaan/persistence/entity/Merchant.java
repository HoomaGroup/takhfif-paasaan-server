package ir.paasaan.persistence.entity;

import javax.persistence.*;

/**
 * @author Boshra Taheri
 * @since 11/25/2015
 */
@Entity
@Table(name = "MERCHANT")
@PrimaryKeyJoinColumn(name="USER_ID")
public class Merchant extends User {

    @Column(name = "LATITUDE")
    private Double latitude;
    @Column(name = "LONGITUDE")
    private Double longitude;
    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;
    @Column(name = "DEPOSIT")
    private String selectedDepositNumber;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getSelectedDepositNumber() {
        return selectedDepositNumber;
    }

    public void setSelectedDepositNumber(String selectedDepositNumber) {
        this.selectedDepositNumber = selectedDepositNumber;
    }
}
