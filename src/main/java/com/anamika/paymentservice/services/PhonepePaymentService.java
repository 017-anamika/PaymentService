package com.anamika.paymentservice.services;

import org.springframework.stereotype.Service;

@Service
public class PhonepePaymentService implements PaymentService {
    @Override
    public String generatePaymentLink(String orderId) {
        return "";
    }
}
