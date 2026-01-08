package com.example.wallet.model;

public class BankAccount {

    private String id;
    private String walletId;
    private String accountNumber;
    private String accountName;
    private String bank;

    public BankAccount(String id, String walletId, String accountNumber, String accountName, String bank) {
        this.id = id;
        this.walletId = walletId;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.bank = bank;
    }

    public String getWalletId() { return walletId; }
    public String getAccountNumber() { return accountNumber; }
    public String getBank() { return bank; }
}
