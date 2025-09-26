package com.anamika.paymentservice.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class StripePaymentService implements PaymentService{
    @Override
    public String generatePaymentLink(String orderId) {
        return "";
    }
}
