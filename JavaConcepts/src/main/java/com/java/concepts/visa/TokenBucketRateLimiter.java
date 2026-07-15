package com.java.concepts.visa;

import java.util.concurrent.locks.ReentrantLock;

public class TokenBucketRateLimiter {
    private final long maxCapacity;
    private final long refillRatePerSecond;
    private final ReentrantLock lock= new ReentrantLock();

    private double currentTokens;
    private long lastRefillTimestampNanos;


    public TokenBucketRateLimiter(long maxCapacity, long refillRatePerSecond) {
        this.maxCapacity = maxCapacity;
        this.refillRatePerSecond = refillRatePerSecond;
        this.currentTokens = maxCapacity;
        this.lastRefillTimestampNanos = System.nanoTime();
    }

    public boolean allowRequest(int tokensToConsume) {
        lock.lock();
        try {
            refill();
            if (tokensToConsume <= currentTokens) {
                currentTokens -= tokensToConsume;
                return true;
            }
            return false;
        } finally {
                  lock.unlock();
        }
    }

    private void refill() {
        long now = System.nanoTime();
        double timeElapsedInSeconds = (now - lastRefillTimestampNanos) / 1_000_000_000.0;
        currentTokens = Math.min(maxCapacity, currentTokens + (refillRatePerSecond * timeElapsedInSeconds));
        lastRefillTimestampNanos = now;
    }

    public static void main(String[] args) {
        TokenBucketRateLimiter limiter = new TokenBucketRateLimiter(10, 5);
        System.out.println(limiter.allowRequest(15));
    }
}
