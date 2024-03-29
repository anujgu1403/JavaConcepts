package com.java.concepts.linkedlist;

import java.util.HashSet;

public class LinkedList {
	Node head;

	public void insert(int data) {
		Node node = new Node();
		node.data = data;

		if (head == null) {
			head = node;
		} else {
			Node n = head;
			while (n.next != null) {
				n = n.next;
			}
			n.next = node;
		}
	}

	public void insertAtStart(int data) {
		Node node = new Node();
		node.data = data;
		node.next = head;
		head = node;
	}

	public void insertAt(int index, int data) {

		Node node = new Node();
		node.data = data;
		node.next = null;

		if (index == 0) {
			insertAtStart(data);
		} else {
			Node n = head;
			for (int i = 0; i < index; i++) {
				n = n.next;
			}
			node.next = n.next;
			n.next = node;
		}
	}

	public void deleteAt(int index) {
		if(index ==0) {
			head=head.next;
		}
		else {
			Node n = head;
			Node n1=null;
			for (int i = 0; i < index; i++) {
				n = n.next;
			}
			n1 = n.next;
			n.next = n1.next;
		}	
		
	}
	
	public void reverse() {
		Node  pointer= head;
		Node  previous= null, current = null;
		
		while(pointer!=null) {
			current = pointer;
			pointer= current.next;
			
			//reverse the list
			current.next = previous;
			previous = current;
			head = current;
		}
		
	}
	
	public boolean detectLoop() {
		HashSet<Node> hashSet= new HashSet<Node>();
		Node node = head;
		
		while(node.next!=null) {
			if(hashSet.contains(node.next)) {
				return true;
			}else {
				hashSet.add(node.next);
			}
			node=node.next;
		}
		return false;
	}
	
	public void display() {
		Node node = head;

		while (node.next != null) {
			System.out.println("Node Value: " + node.data);
			node = node.next;
		}
		System.out.println("Node Value: " + node.data);

	}

}
