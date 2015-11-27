package ir.paasaan.dto;

import java.math.BigDecimal;

/**
 * @author arman
 * @since 11/27/2015.
 */
public class PayByIdPreviewResponse {

    private String merchantName;
    private String merchantId;
    private BigDecimal amount;

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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PayByIdPreviewResponse{" +
                "merchantName='" + merchantName + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
