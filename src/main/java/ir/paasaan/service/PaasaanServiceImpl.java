package ir.paasaan.service;

import ir.paasaan.dto.GeneratePaymentIdRequest;
import ir.paasaan.dto.GeneratePaymentIdResponse;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Boshra Taheri
 * @since 11/14/2015
 */
@Component
@Transactional(isolation = Isolation.READ_COMMITTED)
public class PaasaanServiceImpl implements PaasaanService {

    public GeneratePaymentIdResponse generatePaymentId(GeneratePaymentIdRequest request) {
        GeneratePaymentIdResponse response = new GeneratePaymentIdResponse();
        response.setPaymentId("12345678");
        return response;
    }
}
