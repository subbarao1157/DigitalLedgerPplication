package com.example.DIgitalLedgerApp.Controllers;


import com.example.DIgitalLedgerApp.ServiceLayer.PaymentService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class PaymentController {

    @Autowired
    private PaymentService ps;

    private static final String SUCCESS_URL = "http://localhost:2005/paypal/success";
    private static final String CANCEL_URL = "http://localhost:2005/paypal/cancel";

    @GetMapping("/pay")
    public String payment() {
        try {
            Payment payment = ps.createPayment(10.00, "USD", "paypal",
                    "sale", "Payment description", CANCEL_URL, SUCCESS_URL);
            for (Links link : payment.getLinks()) {
                if (link.getRel().equals("approval_url")) {
                    return "redirect:" + link.getHref();
                }
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping("/paypal/success")
    public String successPayment(@RequestParam("paymentId") String paymentId,
                                 @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = ps.executePayment(paymentId, payerId);
            if (payment.getState().equals("approved")) {
                return "Payment successful!";
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        return "Payment failed!";
    }

    @GetMapping("/paypal/cancel")
    public String cancelPayment() {
        return "Payment canceled!";
    }
}
