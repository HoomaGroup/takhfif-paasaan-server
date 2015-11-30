package ir.paasaan;

import ir.paasaan.dto.GeneratePaymentIdRequest;
import ir.paasaan.dto.GeneratePaymentIdResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class PaasaanControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(PaasaanControllerTest.class);

    public static void main(String[] args) {
        PaasaanControllerTest test = new PaasaanControllerTest();
        test.testGeneratePaymentId();
    }

    private void testGeneratePaymentId() {
        logger.info("****started executing 'testGeneratePaymentId'****");
        RestTemplate restTemplate = new RestTemplate();
        GeneratePaymentIdRequest request = new GeneratePaymentIdRequest();
        request.setMerchantId("123");
        request.setAmount(new BigDecimal("100000"));
        ResponseEntity<GeneratePaymentIdResponse> response =
                restTemplate.postForEntity("http://localhost:8080/api/paasaan/generatePaymentId", request, GeneratePaymentIdResponse.class);
        logger.info("status code {}", response.getStatusCode());
        logger.info("response: {}", response);

        logger.info("****finished executing 'testGeneratePaymentId'****");
    }

}
