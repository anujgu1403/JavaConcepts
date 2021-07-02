package com.java.concepts.multithreading;

public class Task2 implements Runnable{
    @Override
    public void run() {
        System.out.println("Executing task 2");
        try{
            Thread.sleep(200);
        }catch (InterruptedException ie){

        }
    }
}
