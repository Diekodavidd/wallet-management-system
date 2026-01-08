package com.example.wallet.service.payment;

public interface PaymentGateway {
    void process(double amount, String reference);
}
