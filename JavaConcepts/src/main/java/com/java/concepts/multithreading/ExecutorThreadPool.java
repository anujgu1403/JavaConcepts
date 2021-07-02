package com.java.concepts.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerAgentThread implements Runnable {

    private String message;

    public WorkerAgentThread(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start message: " + message);
        try {
            processMessage();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " End.");
    }

    private void processMessage() throws InterruptedException {
        Thread.sleep(100);
    }
}

public class ExecutorThreadPool {

    public static void main(String[] args) {
        ExecutorService es = Executors.newScheduledThreadPool(10);
        for (int i = 0; i < 20; i++) {
            Runnable runner = new WorkerAgentThread("Thread " + i);
            es.submit(runner);
        }

        es.shutdown();
        while (!es.isTerminated()) {
        }

        System.out.println("All threads finished.");
    }

}
