package com.java.concepts.visa.producerconsumer;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class PaymentEvent {

    private String transactionId;
    private String merchantId;
    private String cardHash;
    private BigDecimal amount;
    private String currency;
    private PaymentStatus status;
    private Instant timestamp;

    public PaymentEvent() {
    }

    public PaymentEvent(String transactionId,
                        String merchantId,
                        String cardHash,
                        BigDecimal amount,
                        String currency,
                        PaymentStatus status,
                        Instant timestamp) {

        this.transactionId = transactionId;
        this.merchantId = merchantId;
        this.cardHash = cardHash;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
        this.timestamp = timestamp;
    }

    public static PaymentEvent generate() {

        return new PaymentEvent(
                UUID.randomUUID().toString(),
                "MERCHANT-" + (int)(Math.random() * 100),
                "CARD-" + (int)(Math.random() * 1000),
                BigDecimal.valueOf((Math.random() * 10000) + 100),
                "USD",
                PaymentStatus.AUTHORIZED,
                Instant.now()
        );
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public String getCardHash() {
        return cardHash;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "PaymentEvent{" +
                "transactionId='" + transactionId + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", cardHash='" + cardHash + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", status=" + status +
                ", timestamp=" + timestamp +
                '}';
    }
}
