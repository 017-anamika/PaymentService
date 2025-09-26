package com.anamika.paymentservice.services;

import com.stripe.exception.StripeException;

public interface PaymentService {
    String generatePaymentLink(String orderId) ;

}
