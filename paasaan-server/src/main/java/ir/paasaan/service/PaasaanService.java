package ir.paasaan.service;

import ir.paasaan.dto.*;

/**
 * @author Boshra Taheri
 * @since 11/14/2015
 */
public interface PaasaanService {
    GeneratePaymentIdResponse generatePaymentId(GeneratePaymentIdRequest request);

    PayByIdPreviewResponse payByIdPreview(PayByIdPreviewRequest request);

    PayByIdResponse payById(PayByIdRequest request);

    SearchDiscountResponse searchDiscount(SearchDiscountRequest request);

    SearchPaymentResponse searchPayment(SearchPaymentRequest request);
}
