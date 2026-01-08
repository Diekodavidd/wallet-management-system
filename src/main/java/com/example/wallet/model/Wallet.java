package com.example.wallet.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Wallet {

    private String id;
    private String email;
    private String phoneNumber;
    private double balance;
    private LocalDateTime createdAt;
    private List<BankAccount> banks;

    public Wallet(String id, String email, String phoneNumber) {
        this.id = id;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.balance = 0;
        this.createdAt = LocalDateTime.now();
        this.banks = new ArrayList<>();
    }


    public String getId() { return id; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public List<BankAccount> getBanks() { return banks; }


    public void addBank(BankAccount bank) {
        this.banks.add(bank);
    }
}
