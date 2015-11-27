package ir.paasaan.service;

import ir.paasaan.dto.*;
import ir.paasaan.persistence.dao.impl.CustomerDaoImpl;
import ir.paasaan.persistence.dao.impl.MerchantDaoImpl;
import ir.paasaan.persistence.dao.impl.PaymentDaoImpl;
import ir.paasaan.persistence.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author Boshra Taheri
 * @since 11/14/2015
 */
@Component
@Transactional(isolation = Isolation.READ_COMMITTED)
public class PaasaanServiceImpl implements PaasaanService {

    @Autowired
    private PaymentDaoImpl paymentDao;

    @Autowired
    private MerchantDaoImpl merchantDao;

    @Autowired
    private CustomerDaoImpl customerDao;

    public GeneratePaymentIdResponse generatePaymentId(GeneratePaymentIdRequest request) {
        Long merchantId = null;
        GeneratePaymentIdResponse response = new GeneratePaymentIdResponse();
        try {
            merchantId = Long.valueOf(request.getMerchantId());
        } catch (NumberFormatException e) {
            return response;
        }
        Merchant merchant = merchantDao.get(merchantId);
        if(merchant == null){
            return response;
        }
        Payment payment = new Payment();
        Discount discount = merchant.getDiscounts().get(0);
        payment.setDiscount(discount);
        payment.setCreationDate(new Date());
        payment.setAmount(request.getAmount());
        payment.setStatus(PaymentStatus.PENDING);
        paymentDao.saveOrUpdate(payment);
        response.setPaymentId(String.valueOf(payment.getId()));
        return response;
    }

    public PayByIdPreviewResponse payByIdPreview(PayByIdPreviewRequest request) {
        PayByIdPreviewResponse payByIdPreviewResponse = new PayByIdPreviewResponse();
        Payment payment = paymentDao.getPaymentsInfo(request.getPaymentId());
        if (payment != null) {
            payByIdPreviewResponse.setAmount(payment.getAmount());
            payByIdPreviewResponse.setMerchantName(payment.getDiscount().getMerchant().getName());
            payByIdPreviewResponse.setMerchantId(String.valueOf(payment.getDiscount().getMerchant().getId()));
        }
        return payByIdPreviewResponse;
    }

    public PayByIdResponse payById(PayByIdRequest request) {
        PayByIdResponse response = new PayByIdResponse();
        response.setSuccess(false);
        Long paymentId;
        try {
            paymentId = Long.valueOf(request.getPaymentId());
        } catch (NumberFormatException e) {
            return response;
        }
        Customer customer = customerDao.get(request.getCustomerId());
        if (customer == null){
            return response;
        }
        Payment payment = paymentDao.get(paymentId);
        payment.setCustomer(customer);
        payment.setScore(request.getScore());
        payment.setComment(request.getComment());
        payment.setStatus(PaymentStatus.DONE);//todo add Pending Service Status
        payment.setPaymentDate(new Date());
        payment.setReferenceNumber(paymentId.toString() +
                payment.getDiscount().getMerchant().getId() +
                payment.getCustomer().getId());
        paymentDao.saveOrUpdate(payment);
        //todo important must Service call from in bank
        response.setSuccess(true);
        return response;
    }

    public SearchDiscountResponse searchDiscount(SearchDiscountRequest request) {
        return new SearchDiscountResponse();
    }

    public SearchPaymentResponse searchPayment(SearchPaymentRequest request) {
        return new SearchPaymentResponse();
    }
}
