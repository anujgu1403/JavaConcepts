package com.java.concepts.multithreading;

class Basic {

   static synchronized void increment(){
       for(int i=0;i<5;i++){
           System.out.println("Thread : "+i);
       }
    }
}

class DemoThread extends Thread{
    Basic b;

    public DemoThread(Basic b){
        this.b= b;
    }
    public void run(){
        b.increment();
    }
}

public class ClassLevelSync{
    public static void main(String[] args) throws InterruptedException {
        Basic b1 = new Basic();
        Basic b2 = new Basic();
        DemoThread t1 = new DemoThread(b1);
        DemoThread t2 = new DemoThread(b2);

        t1.start();

        t2.start();


    }
}
