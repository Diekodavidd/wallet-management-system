package com.example.wallet.service.payment;

public class PaystackGateway implements PaymentGateway {

    @Override
    public void process(double amount, String reference) {
        System.out.println("[PAYSTACK] Payment successful | Amount: ₦" + amount + " | Ref: " + reference);
    }
}
