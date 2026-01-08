package com.example.wallet.service;

import com.example.wallet.model.*;
import com.example.wallet.service.payment.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WalletService {

    private final List<Wallet> wallets = new ArrayList<>();
    private final List<Transaction> transactions = new ArrayList<>();


    public Wallet createWallet(String email, String phone) {
        if (wallets.stream().anyMatch(w -> w.getEmail().equals(email))) {
            throw new RuntimeException("Email already exists");
        }
        Wallet wallet = new Wallet(UUID.randomUUID().toString(), email, phone);
        wallets.add(wallet);
        return wallet;
    }


    public Wallet getWalletByEmail(String email) {
        return wallets.stream()
                .filter(w -> w.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Wallet not found"));
    }


    public BankAccount linkBank(String walletId, String accNo, String accName, String bankName) {
        Wallet wallet = wallets.stream()
                .filter(w -> w.getId().equals(walletId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Wallet not found"));

        boolean exists = wallet.getBanks().stream()
                .anyMatch(b -> b.getAccountNumber().equals(accNo) && b.getBank().equals(bankName));
        if (exists) throw new RuntimeException("Bank account already linked");

        BankAccount bank = new BankAccount(UUID.randomUUID().toString(), walletId, accNo, accName, bankName);
        wallet.addBank(bank);
        return bank;
    }


    public List<BankAccount> getBanksByWallet(String walletId) {
        Wallet wallet = wallets.stream()
                .filter(w -> w.getId().equals(walletId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Wallet not found"));
        return wallet.getBanks();
    }


    public String fundWallet(String walletId, String accNo, String gateway, double amount) {

        Wallet wallet = wallets.stream()
                .filter(w -> w.getId().equals(walletId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Wallet not found"));

        boolean isLinked = wallet.getBanks().stream()
                .anyMatch(b -> b.getAccountNumber().equals(accNo));

        if (!isLinked) {
            throw new IllegalArgumentException("Account number is not linked to this wallet.");
        }

        PaymentGateway paymentGateway = PaymentGatewayFactory.getGateway(gateway);
        String ref = UUID.randomUUID().toString();
        paymentGateway.process(amount, ref);

        wallet.setBalance(wallet.getBalance() + amount);

        Transaction txn = new Transaction(UUID.randomUUID().toString(), walletId, amount, gateway);
        transactions.add(txn);

        return "Wallet funded successfully. Ref: " + ref;
    }


    public List<Transaction> getTransactions(String walletId) {
        return transactions.stream()
                .filter(t -> t.getWalletId().equals(walletId))
                .toList();
    }
}
