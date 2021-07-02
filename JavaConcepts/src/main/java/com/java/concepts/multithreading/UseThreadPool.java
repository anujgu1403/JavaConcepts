package com.java.concepts.multithreading;

import java.util.Random;

public class UseThreadPool {
    public static void main(String[] args) {
        Task1 t1 = new Task1();
        Task2 t2 = new Task2();
        int taskCount =0;
        ThreadPool threadPool = new ThreadPool(2, 2);

        while (taskCount<50){
            Random random = new Random();
            int n = random.nextInt(4);
            if(n==0){
                threadPool.execute(t1);
            }else if(n==1)
                threadPool.execute(t2);
            taskCount++;
            try{
                Thread.sleep(100);
            }catch (InterruptedException ie){

            }
        }

    }
}
