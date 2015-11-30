package ir.paasaan;

import ir.paasaan.invoker.ObgOAuthServiceInvoker;
import ir.paasaan.invoker.dto.PaasaanOAuthClientInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Boshra Taheri
 * @since 11/30/2015
 */
public class ObgOAuthTest {
    private static ObgOAuthServiceInvoker serviceInvoker = new ObgOAuthServiceInvoker();

    public static void main(String[] args) {
        testGetUserConsent();
    }

    public static void testGetUserConsent() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("client_id", PaasaanOAuthClientInfo.CLIENT_ID);
        parameters.put("redirect_uri", PaasaanOAuthClientInfo.REDIRECTION_URI);
        parameters.put("response_type", "code");
        parameters.put("state", "123456");
        serviceInvoker.getUserConsent(parameters);
    }
}
