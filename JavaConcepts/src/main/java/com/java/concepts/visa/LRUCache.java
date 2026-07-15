package com.java.concepts.visa;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private final LinkedHashMap<Integer, Integer> cache;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        // The 3rd argument 'true' activates access-order iteration
        // (most recently accessed items move to the end)
        this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                // Automatically evicts the oldest item when size exceeds capacity
                return size() > LRUCache.this.capacity;
            }
        };
    }

    public int get(int key) {
        // LinkedHashMap automatically moves accessed key to the end of the line
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1); // cache is {1=1}
        lruCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lruCache.get(1)); // return 1
        lruCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lruCache.get(2)); // returns -1 (not found)
        lruCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}L
        System.out.println(lruCache.get(4));
    }
}