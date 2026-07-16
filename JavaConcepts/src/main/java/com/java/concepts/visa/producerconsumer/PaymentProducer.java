package com.java.concepts.visa.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class PaymentProducer implements Runnable {

    private final BlockingQueue<PaymentEvent> queue;

    public PaymentProducer(BlockingQueue<PaymentEvent> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        try {

            while (true) {

                PaymentEvent event = PaymentEvent.generate();

                queue.put(event);

                System.out.println(
                        "Produced : " + event.getTransactionId());

                Thread.sleep(500);

            }

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

        }
    }
}