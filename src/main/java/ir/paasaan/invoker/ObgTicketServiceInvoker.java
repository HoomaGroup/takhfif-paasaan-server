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
public class ObgTicketServiceInvoker {
    private static Logger logger = LoggerFactory.getLogger(ObgTicketServiceInvoker.class);
    private static final String TICKET_SERVICES_ENDPOINT_URL = "http://obg.in-bank.ir/apibank/api/v0/ticket/transfer";

    public NormalTransferTicketResponse getNormalTransferTicket(NormalTransferTicketRequest request) {
        logger.info("****getNormalTransferTicket Request: {}", request);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<NormalTransferTicketResponse> response =
                restTemplate.postForEntity(TICKET_SERVICES_ENDPOINT_URL + "/local/" + request.getAccountNo(), request, NormalTransferTicketResponse.class);

        logger.info("****getNormalTransferTicket Response: {}", response);
        return response.getBody();
    }

    public AchTransferTicketResponse getAchTransferTicket(AchTransferTicketRequest request) {
        logger.info("****getAchTransferTicket Request: {}", request);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AchTransferTicketResponse> response =
                restTemplate.postForEntity(TICKET_SERVICES_ENDPOINT_URL + "/paya/" + request.getAccountNo(), request, AchTransferTicketResponse.class);

        logger.info("****getAchTransferTicket Response: {}", response);
        return response.getBody();
    }

}
