package ir.paasaan.dto;

import java.util.List;

/**
 * @author arman
 * @since 11/27/2015.
 */
public class SearchDiscountResponse {

   private List<MerchantInfoResponse> merchantInfos;

    public List<MerchantInfoResponse> getMerchantInfos() {
        return merchantInfos;
    }

    public void setMerchantInfos(List<MerchantInfoResponse> merchantInfos) {
        this.merchantInfos = merchantInfos;
    }

    @Override
    public String toString() {
        return "SearchDiscountResponse{" +
                "merchantInfos=" + merchantInfos +
                '}';
    }
}
