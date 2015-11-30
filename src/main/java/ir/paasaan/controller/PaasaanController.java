package ir.paasaan.controller;

import ir.paasaan.dto.*;
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

    @RequestMapping(method = RequestMethod.POST, value = "/payByIdPreview")
    public
    @ResponseBody
    PayByIdPreviewResponse payByIdPreview(@RequestBody PayByIdPreviewRequest request) throws Exception {
        try {
            return paasaanService.payByIdPreview(request);
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/payById")
    public
    @ResponseBody
    PayByIdResponse payById(@RequestBody PayByIdRequest request) throws Exception {
        try {
            return paasaanService.payById(request);
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/searchDiscount")
    public
    @ResponseBody
    SearchDiscountResponse searchDiscount(@RequestBody SearchDiscountRequest request) throws Exception {
        try {
            return paasaanService.searchDiscount(request);
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/searchPayment")
    public
    @ResponseBody
    SearchPaymentResponse searchPayment(@RequestBody SearchPaymentRequest request) throws Exception {
        try {
            return paasaanService.searchPayment(request);
        } catch (Exception e) {
            throw e;
        }
    }

}
