package ir.paasaan.service;

import ir.paasaan.dto.*;
import ir.paasaan.persistence.dao.impl.CustomerDaoImpl;
import ir.paasaan.persistence.dao.impl.DiscountDaoImpl;
import ir.paasaan.persistence.dao.impl.MerchantDaoImpl;
import ir.paasaan.persistence.dao.impl.PaymentDaoImpl;
import ir.paasaan.persistence.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private DiscountDaoImpl discountDao;

    public GeneratePaymentIdResponse generatePaymentId(GeneratePaymentIdRequest request) {
        Long merchantId;
        GeneratePaymentIdResponse response = new GeneratePaymentIdResponse();
        try {
            merchantId = Long.valueOf(request.getMerchantId());
        } catch (NumberFormatException e) {
            return response;
        }
        Merchant merchant = merchantDao.get(merchantId);
        if (merchant == null) {
            return response;
        }
        Payment payment = new Payment();
        Discount discount = merchant.getDiscounts().get(0);
        payment.setDiscount(discount);
        payment.setCreationDate(new Date());
        payment.setAmount(request.getAmount());
        payment.setStatus(PaymentStatus.PENDING);
        paymentDao.saveOrUpdate(payment);
        response.setPaymentId(String.valueOf(payment.getGeneratedPaymentId()));
        return response;
    }

    public PayByIdPreviewResponse payByIdPreview(PayByIdPreviewRequest request) {
        PayByIdPreviewResponse payByIdPreviewResponse = new PayByIdPreviewResponse();
        Payment payment = paymentDao.getPaymentsInfo(request.getPaymentId(), PaymentStatus.PENDING);
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
        if (customer == null) {
            return response;
        }
        Payment payment = paymentDao.get(paymentId);
        payment.setCustomer(customer);
        payment.setScore(request.getScore());
        payment.setComment(request.getComment());
        payment.setStatus(PaymentStatus.DONE);//todo add Pending Service Status
        payment.setPaymentDate(new Date());
        payment.setReferenceNumber(payment.getGeneratedPaymentId() + "-" +
                payment.getDiscount().getId() + "-" +
                payment.getId());
        paymentDao.saveOrUpdate(payment);
        //todo important must Service call from in bank
        response.setSuccess(true);
        return response;
    }

    public SearchDiscountResponse searchDiscount(SearchDiscountRequest request) {
        List<Discount> discounts = discountDao.find(request.getDiscountFrom(), request.getDistanceLessThan(), request.getGroupName(), request.getMerchantName(), request.getTags());
        return Assembler.convertToDiscountResponse(discounts,request);
    }

    public SearchPaymentResponse searchPayment(SearchPaymentRequest request) {
        SearchPaymentResponse searchPaymentResponse = new SearchPaymentResponse();
        Payment paymentInfo = paymentDao.getPaymentsInfo(request.getPaymentId(), Assembler.convertToStatus(request.getPaymentStatus()), request.getMerchantId());
        ArrayList<PaymentInfo> paymentInfos = new ArrayList<>();
        paymentInfos.add(Assembler.convertToPaymentInfo(paymentInfo));
        searchPaymentResponse.setPaymentInfos(paymentInfos);
        return searchPaymentResponse;
    }
}
