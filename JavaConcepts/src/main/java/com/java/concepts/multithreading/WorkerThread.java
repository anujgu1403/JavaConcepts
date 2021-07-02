package com.java.concepts.multithreading;

import java.util.concurrent.BlockingQueue;

public class WorkerThread extends Thread{

    BlockingQueue taskQueue = null; // taskQueue for each thread
    boolean isStopped = false;

    public WorkerThread(BlockingQueue queue){
        taskQueue = queue;
    }

    public void run(){
        while(!isStopped){
            try{
                Runnable runnable = (Runnable) taskQueue.take(); // run task from the queue
                runnable.run();
            }catch (Exception e){

            }
        }
    }

    public synchronized void stopThread(){
        isStopped= true;
        this.interrupt();
    }

    public synchronized boolean isStopped(){
        return isStopped;
    }
}
