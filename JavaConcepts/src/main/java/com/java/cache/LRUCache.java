package com.java.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<T> {
    private final int capacity;
    private int size;
    private final Map<String, Node> hashMap;
    private final DoublyLinkedList internalQueue;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size=0;
        this.hashMap = new HashMap<>();
        this.internalQueue = new DoublyLinkedList();

    }

    public T get(final String key) {
        Node node = hashMap.get(key);
        if (node == null) {
            return null;
        }
        internalQueue.moveNodeToFront(node);
        return node.value;
    }

    public void put(final String key, final T value) {

        Node currentNode = hashMap.get(key);
        if(currentNode!=null){
            currentNode.value = value;
            internalQueue.moveNodeToFront(currentNode);
        }
        if(size==capacity){
            String rearNodekey = internalQueue.getRearKey();
            internalQueue.removeNodeFromRear();
            hashMap.remove(rearNodekey);
            size--;
        }

        Node node = new Node(key,value);
        internalQueue.addNodeToFront(node);
        hashMap.put(key, node);
        size++;
    }

    private class Node {
        String key;
        T value;
        Node next, prev;

        private Node(final String key, final T value) {
            this.key = key;
            this.value = value;
            this.next = this.prev = null;
        }
    }

    private class DoublyLinkedList {
        Node rear, front;

        public DoublyLinkedList() {
            rear = front = null;
        }

        private void moveNodeToFront(final Node node){
            if(front == node){
                return;
            }
            if(node==rear){
                rear = rear.prev;
                rear.next= null;
            }else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            node.prev=null;
            node.next=front;
            front.prev = node;
            front=node;
        }

        private void removeNodeFromRear(){

            if (rear==null)
                return;

            System.out.println("Removed rear node "+rear.value);
            if(front==rear){
                front=rear=null;
            }else{
                rear=rear.prev;
                rear.next=null;
            }

        }

        private String getRearKey() {
            return rear.key;
        }

        public void addNodeToFront(final Node node) {
            if(rear==null){
                rear = front = node;
                return;
            }
            node.next = front;
            front.prev = node;
            front = node;
        }
    }
}
