package com.java.concepts.visa.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class PaymentConsumer implements Runnable {

    private final BlockingQueue<PaymentEvent> queue;

    public PaymentConsumer(BlockingQueue<PaymentEvent> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        try {

            while (true) {

                PaymentEvent event = queue.take();

                process(event);

            }

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

        }

    }

    private void process(PaymentEvent event) {

        System.out.println(
                "Processing : " + event.getTransactionId());

    }
}
