package com.anamika.paymentservice.services;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.ProductCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class StripePaymentService implements PaymentService {

    @Value("${STRIPE_KEY}")
    private String stripekey;

//    @Value("${stripe.key.secret}")
//    private String stripekey;

    @Override
    public String generatePaymentLink(String orderId) {
        Stripe.apiKey = stripekey;

        try {
            ProductCreateParams productCreateParams =
                    ProductCreateParams.builder().setName("Water Bottle").build();

            Product product = Product.create(productCreateParams);

            PriceCreateParams priceCreateParams =
                    PriceCreateParams.builder()
                            .setCurrency("inr")
                            .setUnitAmount(1000L)
                            .setProduct(product.getId())
                            .build();

            Price price = Price.create(priceCreateParams);

            PaymentLinkCreateParams params =
                    PaymentLinkCreateParams.builder()
                            .addLineItem(
                                    PaymentLinkCreateParams.LineItem.builder()
                                            .setPrice(price.getId())
                                            .setQuantity(1L)
                                            .build()
                            )
                            .setAfterCompletion(
                                    PaymentLinkCreateParams.AfterCompletion.builder()
                                            .setRedirect(
                                                    PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                                            .setUrl("https://scaler.com")
                                                            .build()
                                            )
                                            .build()
                            )
                            .build();

            PaymentLink paymentLink = PaymentLink.create(params);
            return paymentLink.getUrl();
        } catch (StripeException e) {
            throw new RuntimeException("Failed to generate Stripe payment link", e);
        }
    }
}
