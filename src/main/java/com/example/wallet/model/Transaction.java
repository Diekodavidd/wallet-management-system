package com.example.wallet.model;

import java.time.LocalDateTime;

public class Transaction {

    private String id;
    private String walletId;
    private double amount;
    private String gateway;
    private LocalDateTime createdAt;

    public Transaction(String id, String walletId, double amount, String gateway) {
        this.id = id;
        this.walletId = walletId;
        this.amount = amount;
        this.gateway = gateway;
        this.createdAt = LocalDateTime.now();
    }

    public String getId() { return id; }
    public String getWalletId() { return walletId; }
    public double getAmount() { return amount; }
    public String getGateway() { return gateway; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
