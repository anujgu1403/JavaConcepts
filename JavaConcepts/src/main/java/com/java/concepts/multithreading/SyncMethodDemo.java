package com.java.concepts.multithreading;

class SyncMethod {
    int count;
    // Method synchronization
   public synchronized void increment(){
       String tName = Thread.currentThread().getName();
       System.out.println(tName);
           count++;
    }

    // Block synchronization
    public void incrementInBlock(){
        String tName = Thread.currentThread().getName();
        System.out.println(tName);
        synchronized(this){
            count++;
        }
    }

}

public class SyncMethodDemo{
    public static void main(String[] args) throws InterruptedException {

        SyncMethod syncMethod = new SyncMethod();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<1000;i++){
                    syncMethod.increment();
                    syncMethod.incrementInBlock();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<1200;i++){
                    syncMethod.increment();
                    syncMethod.incrementInBlock();
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(syncMethod.count);

    }

}
