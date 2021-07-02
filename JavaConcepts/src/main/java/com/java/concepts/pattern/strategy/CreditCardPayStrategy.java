package com.java.concepts.pattern.strategy;

public class CreditCardPayStrategy implements PayStrategy {

    private String cardNumber;
    private String name;
    private String cvv;
    private String expiry;

    public CreditCardPayStrategy(String cardNumber, String name, String cvv, String expiry) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.cvv = cvv;
        this.expiry = expiry;
    }

    public void pay(int amount) {
        System.out.println(amount + " paid by credit card");
    }
}
