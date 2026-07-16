package com.java.concepts.visa.producerconsumer;

public enum PaymentStatus {
    PENDING("Payment is awaiting processing"),
    PROCESSING("Payment is being processed"),
    COMPLETED("Payment has been successfully completed"),
    FAILED("Payment processing failed"),
    CANCELLED("Payment has been cancelled"),
    AUTHORIZED(""),
    REFUNDED("Payment has been refunded");

    private final String description;

    PaymentStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public boolean isTerminal() {
        return this == COMPLETED || this == FAILED || this == CANCELLED || this == REFUNDED;
    }

    public boolean isActive() {
        return this == PENDING || this == PROCESSING;
    }
}
