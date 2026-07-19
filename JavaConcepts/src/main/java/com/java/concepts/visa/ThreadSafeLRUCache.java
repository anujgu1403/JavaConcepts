package com.java.concepts.visa;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeLRUCache<K, V> {

    // Internal node structure for the doubly linked list
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<K, Node<K, V>> map;
    private final Node<K, V> head;
    private final Node<K, V> tail;

    // ReadWriteLock to maximize concurrent read performance
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public ThreadSafeLRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Initialize dummy head and tail nodes to avoid null pointer checks
        this.head = new Node<>(null, null);
        this.tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {
        rwLock.readLock().lock();
        try {
            if (!map.containsKey(key)) {
                return null;
            }

            // Upgrade handling: To move a node to the head, we need a write lock.
            // In standard Java, you cannot upgrade a read lock directly to a write lock.
            // So we release the read lock and acquire the write lock safely.
        } finally {
            rwLock.readLock().unlock();
        }

        rwLock.writeLock().lock();
        try {
            Node<K, V> node = map.get(key);
            if (node != null) {
                moveToHead(node);
                return node.value;
            }
            return null;
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public void put(K key, V value) {
        rwLock.writeLock().lock();
        try {
            Node<K, V> node = map.get(key);

            if (node != null) {
                // Key exists: Update value and move to head
                node.value = value;
                moveToHead(node);
            } else {
                // New Key: Check capacity limits
                if (map.size() >= capacity) {
                    Node<K, V> tailNode = removeTail();
                    if (tailNode != null) {
                        map.remove(tailNode.key);
                    }
                }

                Node<K, V> newNode = new Node<>(key, value);
                map.put(key, newNode);
                addToHead(newNode);
            }
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    // Helper methods for list manipulation (Must be called within a write lock)
    private void addToHead(Node<K, V> node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(Node<K, V> node) {
        removeNode(node);
        addToHead(node);
    }

    private Node<K, V> removeTail() {
        Node<K, V> res = tail.prev;
        if (res == head) {
            return null; // Cache is empty
        }
        removeNode(res);
        return res;
    }

    public static void main(String[] args) {
        ThreadSafeLRUCache<String, String> cache = new ThreadSafeLRUCache<>(5);
        cache.put("1", "Anuj");
        cache.put("2", "Mittal");
        cache.put("3", "Visa");
        cache.put("4", "Java");
        cache.put("5", "Intern");
        cache.put("6", "Co-op");
        System.out.println(cache.get("1"));
        System.out.println(cache.get("6"));
        System.out.println(cache.tail.prev.value);
        System.out.println(cache.head.next.value);
    }
}