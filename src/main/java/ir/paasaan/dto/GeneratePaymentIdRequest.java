package ir.paasaan.dto;

import java.math.BigDecimal;

/**
 * @author Boshra Taheri
 * @since 11/15/2015
 */
public class GeneratePaymentIdRequest {
    private String merchantId;
    private BigDecimal amount;

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
        return "GeneratePaymentIdRequest{" +
                "merchantId='" + merchantId + '\'' +
                ", amount=" + amount +
                '}';
    }
}
