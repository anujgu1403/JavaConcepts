package com.java.cache;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UseCache {

    public static void main(String[] args) throws IOException {
        LRUCache<Integer> cache = new LRUCache<>(3);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice = 1;
        String key;
        Integer value;
        while (choice != 0) {
            System.out.println("1. Put\n 2. Get\n 0. Exit");
            choice = Integer.parseInt(reader.readLine());
            switch (choice) {
                case 1:
                    System.out.println("Enter key");
                    key = reader.readLine();
                    System.out.println("Enter value");
                    value = Integer.parseInt(reader.readLine());
                    cache.put(key, value);
                    System.out.println("Inserted");
                    break;
                case 2:
                    System.out.println("Enter key");
                    key = reader.readLine();
                    System.out.println("Value is: " + cache.get(key) + "\n");
                    break;
                default:
                    System.out.println("Exit");

            }
        }


    }
}
