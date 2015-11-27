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

    @Override
    public String toString() {
        return "SearchDiscountRequest{" +
                "merchantName='" + merchantName + '\'' +
                ", groupName='" + groupName + '\'' +
                ", discountFrom=" + discountFrom +
                ", Tags=" + Tags +
                ", distanceLessThan=" + distanceLessThan +
                '}';
    }
}
