package ir.paasaan.service;

import ir.paasaan.dto.GeneratePaymentIdRequest;
import ir.paasaan.dto.GeneratePaymentIdResponse;

/**
 * @author Boshra Taheri
 * @since 11/14/2015
 */
public interface PaasaanService {
    GeneratePaymentIdResponse generatePaymentId(GeneratePaymentIdRequest request);
}
