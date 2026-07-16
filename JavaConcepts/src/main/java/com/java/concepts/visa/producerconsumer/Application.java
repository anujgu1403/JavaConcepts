package com.java.concepts.visa.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

    public static void main(String[] args) {

        BlockingQueue<PaymentEvent> queue =
                new ArrayBlockingQueue<>(100);

        ExecutorService executor =
                Executors.newFixedThreadPool(5);

        executor.submit(new PaymentProducer(queue));

        executor.submit(new PaymentConsumer(queue));

        executor.submit(new PaymentConsumer(queue));

    }
}
