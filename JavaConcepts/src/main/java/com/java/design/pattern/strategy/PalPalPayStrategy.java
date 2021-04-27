package com.java.design.pattern.strategy;

public class PalPalPayStrategy implements PayStrategy{
    private String email;
    private String password;

    public PalPalPayStrategy(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void pay(int amount) {
        System.out.println(amount+" paid from paypal account.");
    }
}
