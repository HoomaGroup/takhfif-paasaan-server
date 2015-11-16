package ir.paasaan.controller;

import ir.paasaan.dto.GeneratePaymentIdRequest;
import ir.paasaan.dto.GeneratePaymentIdResponse;
import ir.paasaan.service.PaasaanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Boshra Taheri
 * @since 11/14/2015
 */
@RestController
@RequestMapping("/paasaan")
public class PaasaanController {

    @Autowired
    PaasaanService paasaanService;

    @RequestMapping(method = RequestMethod.POST, value = "/generatePaymentId")
    public
    @ResponseBody
    GeneratePaymentIdResponse generatePaymentId(@RequestBody GeneratePaymentIdRequest request) throws Exception {
        try {
            return paasaanService.generatePaymentId(request);
        } catch (Exception e) {
            throw e;
        }
    }
}
