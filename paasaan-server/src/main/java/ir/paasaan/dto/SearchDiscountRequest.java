package ir.paasaan.dto;

import java.util.List;

/**
 * @author arman
 * @since 11/27/2015.
 */
public class SearchDiscountRequest extends CustomerBaseRequest {
    private String merchantName;
    private String groupName;
    private Long discountFrom;
    private List<String> Tags;
    private Long distanceLessThan;
    private Double latitude;
    private Double longitude;


    public Long getDiscountFrom() {
        return discountFrom;
    }

    public void setDiscountFrom(Long discountFrom) {
        this.discountFrom = discountFrom;
    }

    public List<String> getTags() {
        return Tags;
    }

    public void setTags(List<String> tags) {
        Tags = tags;
    }

    public Long getDistanceLessThan() {
        return distanceLessThan;
    }

    public void setDistanceLessThan(Long distanceLessThan) {
        this.distanceLessThan = distanceLessThan;
    }

    public String getMerchantName() {

        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
        return "SearchDiscountRequest{" +
                "merchantName='" + merchantName + '\'' +
                ", groupName='" + groupName + '\'' +
                ", discountFrom=" + discountFrom +
                ", Tags=" + Tags +
                ", distanceLessThan=" + distanceLessThan +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                "} " + super.toString();
    }
}
