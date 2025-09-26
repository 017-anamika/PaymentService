package com.anamika.paymentservice.controllers;

import com.anamika.paymentservice.services.PaymentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentControllers {
    private PaymentService paymentService;
    public PaymentControllers(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/initiate/{orderId")
    public String generatePaymentLink(@PathVariable("orderId") String orderId){
//        Call order service API to get the order details.

        //Logic to generate payment link
        return "Payment link generated successfully";
    }

}
