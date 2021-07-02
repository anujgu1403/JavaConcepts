package com.java.concepts.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadPool {

    BlockingQueue taskQueue = null;
    List<WorkerThread> threads = new ArrayList<>();
    boolean isStopped = false;

    public ThreadPool(int noOfMaxThreads, int noOfMaxTasks) {
        taskQueue = new ArrayBlockingQueue(noOfMaxTasks); // initialise queue with no of max tasks

        for (int i = 0; i < noOfMaxThreads; i++) {
            threads.add(new WorkerThread(taskQueue));// Each thread with its own task queue
        }

        for (WorkerThread thread : threads) {
            thread.start(); // start all the threads
        }

    }

    public synchronized void execute(Runnable task) {

        if (this.isStopped)
            throw new IllegalStateException("ThreadPool is stopped");

        try {
            this.taskQueue.put(task);
        } catch (InterruptedException ie) {
            Logger.getLogger(ThreadPool.class.getName()).log(Level.SEVERE, "");
        }
    }

    public synchronized void stop() {
        this.isStopped = true;
        for (WorkerThread thread : threads)
            thread.stopThread();
    }
}
