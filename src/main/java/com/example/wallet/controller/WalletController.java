package com.example.wallet.controller;

import com.example.wallet.model.*;
import com.example.wallet.service.WalletService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import jakarta.validation.Valid;
import com.example.wallet.controller.dto.FundWalletRequest;
import org.springframework.http.ResponseEntity;




@RestController
@RequestMapping("/")
public class WalletController {

    private final WalletService service;

    public WalletController(WalletService service) {
        this.service = service;
    }


    @GetMapping("/health")
    public String health() {
        return "Wallet service is running";
    }

    @PostMapping("/wallets")
    public Wallet create(@RequestBody Map<String, String> body) {
        return service.createWallet(body.get("email"), body.get("phone"));
    }


    @GetMapping("/wallets")
    public Wallet getByEmail(@RequestParam String email) {
        return service.getWalletByEmail(email);
    }


    @PostMapping("/wallets/{id}/banks")
    public BankAccount linkBank(@PathVariable String id, @RequestBody Map<String, String> body) {
        return service.linkBank(id, body.get("accountNumber"), body.get("accountName"), body.get("bank"));
    }


    
    @GetMapping("/wallets/{id}/banks")
    public List<BankAccount> getBanks(@PathVariable String id) {
        return service.getBanksByWallet(id);
    }


@PostMapping("/wallets/{id}/fund")
public ResponseEntity<String> fund(
        @PathVariable String id,
        @Valid @RequestBody FundWalletRequest request
) {
    try {
        String result = service.fundWallet(
                id,
                request.getAccountNumber(),
                request.getGateway(),
                request.getAmount()
        );
        return ResponseEntity.ok(result);
    } catch (IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}



    @GetMapping("/wallets/{id}/transactions")
    public List<Transaction> transactions(@PathVariable String id) {
        return service.getTransactions(id);
    }
}
