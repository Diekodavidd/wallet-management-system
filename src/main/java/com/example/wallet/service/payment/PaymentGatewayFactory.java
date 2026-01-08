package com.example.wallet.service.payment;

public class PaymentGatewayFactory {

    public static PaymentGateway getGateway(String gateway) {
        return switch (gateway) {
            case "FLUTTERWAVE" -> new FlutterwaveGateway();
            case "PAYSTACK" -> new PaystackGateway();
            default -> throw new IllegalArgumentException("Unsupported payment gateway");
        };
    }
}
