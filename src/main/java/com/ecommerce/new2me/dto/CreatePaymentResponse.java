package com.ecommerce.new2me.dto;

public class CreatePaymentResponse {
    private String clientSecret;

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public CreatePaymentResponse(String clientSecret) {
        this.clientSecret = clientSecret;
    }
}
