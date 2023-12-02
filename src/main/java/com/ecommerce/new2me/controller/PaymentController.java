package com.ecommerce.new2me.controller;

import com.ecommerce.new2me.common.CommonData;
import com.ecommerce.new2me.dto.CreatePayment;
import com.ecommerce.new2me.dto.CreatePaymentResponse;
import com.ecommerce.new2me.model.Product;
import com.ecommerce.new2me.service.ProductService;
import com.google.gson.annotations.SerializedName;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    ProductService productService;


    @PostMapping("/create-payment-intent")
    public CreatePaymentResponse createPaymentIntent(@RequestBody CreatePayment createPayment) throws StripeException {
        double total = CommonData.cart.stream().mapToDouble(Product::getPrice).sum();

        PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder()
                            .setCurrency("npr")
                            .setAmount((long) (total*100L))
//                            .setAutomaticPaymentMethods(
//                                    PaymentIntentCreateParams.AutomaticPaymentMethods
//                                            .builder()
//                                            .setEnabled(true)
//                                            .build()
//                            )
                            .build();

            // Create a PaymentIntent with the order amount and currency
            PaymentIntent intent = PaymentIntent.create(createParams);
            return new CreatePaymentResponse(intent.getClientSecret());

    }
}


