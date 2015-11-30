package ir.paasaan.dto;

import java.util.List;

/**
 * @author arman
 * @since 11/27/2015.
 */
public class MerchantInfoResponse {
    private String merchantName;
    private String merchantId;
    private String groupName;
    private Double discount;
    private List<String> Tags;
    private Long distance;
    private String description;
    private Double latitude;
    private Double longitude;

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public List<String> getTags() {
        return Tags;
    }

    public void setTags(List<String> tags) {
        Tags = tags;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    @Override
    public String toString() {
        return "MerchantInfoResponse{" +
                "merchantName='" + merchantName + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", groupName='" + groupName + '\'' +
                ", discount=" + discount +
                ", Tags=" + Tags +
                ", distance=" + distance +
                ", description='" + description + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
