package ir.paasaan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Boshra Taheri
 * @since 11/14/2015
 */
//@Controller
@RequestMapping("/admin")
@RestController
public class AdminConsoleController {

    @RequestMapping(method = RequestMethod.GET, value = "/paymentIdGenerator")
    public
    @ResponseBody
    ModelAndView paymentIdGenerator() throws Exception {
        try {
            return new ModelAndView("paymentIdGenerator");
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/paymentsReport")
    public
    @ResponseBody
    ModelAndView paymentsReport() throws Exception {
        try {
            return new ModelAndView("paymentsReport");
        } catch (Exception e) {
            throw e;
        }
    }

}
