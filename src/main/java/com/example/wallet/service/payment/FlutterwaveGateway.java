package com.example.wallet.service.payment;

public class FlutterwaveGateway implements PaymentGateway {

    @Override
    public void process(double amount, String reference) {
        System.out.println("[FLUTTERWAVE] Payment successful | Amount: ₦" + amount + " | Ref: " + reference);
    }
}
