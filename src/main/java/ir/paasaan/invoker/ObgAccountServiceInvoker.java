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
public class ObgAccountServiceInvoker {
    private static Logger logger = LoggerFactory.getLogger(ObgAccountServiceInvoker.class);
    private static final String ACCOUNT_SERVICES_ENDPOINT_URL = "http://obg.in-bank.ir/apibank/api/v0/account";

    public AccountBalanceResponse getAccountBalance(AccountBalanceRequest request) {
        logger.info("****getAccountBalance Request: {}", request);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AccountBalanceResponse> response =
                restTemplate.getForEntity(ACCOUNT_SERVICES_ENDPOINT_URL + "/balance/" + request.getAccountNumber(), AccountBalanceResponse.class);

        logger.info("****getAccountBalance Response: {}", response);
        return response.getBody();
    }

    public AccountShortStatementResponse getAccountShortStatement(AccountShortStatementRequest request) {
        logger.info("****getAccountShortStatement Request: {}", request);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AccountShortStatementResponse> response =
                restTemplate.getForEntity(ACCOUNT_SERVICES_ENDPOINT_URL + "/statement/mini/" + request.getAccountNumber(), AccountShortStatementResponse.class);

        logger.info("****getAccountShortStatement Response: {}", response);
        return response.getBody();
    }

    public AccountFullStatementResponse getAccountFullStatement(AccountFullStatementRequest request) {
        logger.info("****getAccountFullStatement Request: {}", request);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AccountFullStatementResponse> response =
                restTemplate.getForEntity(ACCOUNT_SERVICES_ENDPOINT_URL + "/statement/full/"
                        + request.getAccountNumber() + "/" + request.getFromDate() + "/" + request.getToDate()
                        , AccountFullStatementResponse.class);

        logger.info("****getAccountFullStatement Response: {}", response);
        return response.getBody();
    }
}
