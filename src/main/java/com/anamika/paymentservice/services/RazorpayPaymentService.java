package com.anamika.paymentservice.services;

import org.springframework.stereotype.Service;

@Service
public class RazorpayPaymentService implements PaymentService {
    @Override
    public String generatePaymentLink(String orderId) {
        return "Razorpay not supported";
    }
}
