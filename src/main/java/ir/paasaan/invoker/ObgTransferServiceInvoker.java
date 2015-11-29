package ir.paasaan.invoker;

import ir.paasaan.invoker.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Open Banking Gateway Service Invoker
 *
 * @author Boshra Taheri
 * @since 11/27/2015
 */
@Component
public class ObgTransferServiceInvoker {
    private static Logger logger = LoggerFactory.getLogger(ObgTransferServiceInvoker.class);
    private static final String TRANSFER_SERVICES_ENDPOINT_URL = "http://obg.in-bank.ir/apibank/api/v0/transfer";

    public NormalTransferResponse normalTransfer(NormalTransferRequest request) {
        logger.info("****normalTransfer Request: {}", request);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<NormalTransferResponse> response =
                restTemplate.postForEntity(TRANSFER_SERVICES_ENDPOINT_URL + "/local/" + request.getAccountNo(), request, NormalTransferResponse.class);

        logger.info("****normalTransfer Response: {}", response);
        return response.getBody();
    }

    public AchTransferResponse achTransfer(AchTransferRequest request) {
        logger.info("****achTransfer Request: {}", request);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AchTransferResponse> response =
                restTemplate.postForEntity(TRANSFER_SERVICES_ENDPOINT_URL + "/paya/" + request.getAccountNo(), request, AchTransferResponse.class);

        logger.info("****achTransfer Response: {}", response);
        return response.getBody();
    }
}
