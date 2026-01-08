# Wallet Management System

This project is a simple wallet management backend built with Java Spring Boot.
It has a wallet API and a palindrome checker utility.

---

## Features
- Create wallet
- Link bank accounts
- Fund wallet (simulated payment gateways)
- View wallet transactions
- Check if a number is a palindrome

---

## Payment Gateways
Payment gateways (Paystack & Flutterwave) are simulated with log statements — no real money is involved.

---

## How to Run

# Build the project
mvn clean install

# Run the app
mvn spring-boot:run

# App runs on http://localhost:8080

---

## API Endpoints

POST   /api/wallets                - Create a wallet
GET    /api/wallets?email=         - Get wallet by email
POST   /api/wallets/{id}/banks     - Link bank account to wallet
GET    /api/wallets/{id}/banks     - Get all banks linked to a wallet
POST   /api/wallets/{id}/fund      - Fund wallet via simulated gateway
GET    /api/wallets/{id}/transactions - View wallet transactions

---

## Palindrome Utility

Check if a number is a palindrome:

```java
public class PalindromeUtil {
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }
        return x == reversedHalf || x == reversedHalf / 10;
    }
}


## How to Test
Run tests

mvn test