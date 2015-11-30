package ir.paasaan.invoker;

import ir.paasaan.invoker.dto.AccessTokenRequest;
import ir.paasaan.invoker.dto.AccessTokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Open Banking Gateway Service Invoker
 *
 * @author Boshra Taheri
 * @since 11/27/2015
 */
@Component
public class ObgOAuthServiceInvoker {
    private static Logger logger = LoggerFactory.getLogger(ObgOAuthServiceInvoker.class);
    private static final String OAUTH_SERVICES_ENDPOINT_URL = "http://obg.in-bank.ir/apibank/oauth";

    public void getUserConsent(Map<String, String> requestParameters) {
        logger.info("****getUserConsent Request: {}", requestParameters);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForEntity(OAUTH_SERVICES_ENDPOINT_URL + "/authorize", null, requestParameters);

    }

    public AccessTokenResponse getAccessToken(AccessTokenRequest request) {
        logger.info("****getAccessToken Request: {}", request);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AccessTokenResponse> response =
                restTemplate.getForEntity(OAUTH_SERVICES_ENDPOINT_URL + "/token", AccessTokenResponse.class);

        logger.info("****getAccessToken Response: {}", response);
        return response.getBody();
    }

}
