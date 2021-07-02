package com.java.concepts.multithreading;

public class Task1 implements Runnable{
    @Override
    public void run() {
        System.out.println("Executing task 1");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException ie){

        }
    }
}
