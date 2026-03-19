package com.java.concepts.cache;

import java.util.HashMap;
import java.util.Map;

class LRUCacheWithoutDL {
    static class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) { this.key = k; this.value = v; }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head, tail;

    public LRUCacheWithoutDL(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insertAtHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            map.remove(tail.prev.key);
            remove(tail.prev);
        }
        Node newNode = new Node(key, value);
        insertAtHead(newNode);
        map.put(key, newNode);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    // Main method to simulate and run the code
    public static void main(String[] args) {
        System.out.println("Initializing LRU Cache with capacity 2...");
        LRUCacheWithoutDL cache = new LRUCacheWithoutDL(2);

        cache.put(1, 1); // Cache: {1=1}
        cache.put(2, 2); // Cache: {1=1, 2=2}
        System.out.println("Get(1): " + cache.get(1)); // Returns 1, Moves 1 to head

        cache.put(3, 3); // Evicts key 2 (Least Recently Used)
        System.out.println("Get(2): " + cache.get(2)); // Returns -1 (not found)

        cache.put(4, 4); // Evicts key 1
        System.out.println("Get(1): " + cache.get(1)); // Returns -1 (not found)
        System.out.println("Get(3): " + cache.get(3)); // Returns 3
        System.out.println("Get(4): " + cache.get(4)); // Returns 4
    }
}