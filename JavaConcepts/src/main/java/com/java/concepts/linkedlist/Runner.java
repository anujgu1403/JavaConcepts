package com.java.concepts.linkedlist;

public class Runner {

	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		list.insert(11);
		list.insert(19);
		list.insert(71);
		list.insert(13);
		list.insert(51);
		list.insertAtStart(88);
		list.insertAt(0, 10);
		list.display();
		list.reverse();
		list.deleteAt(4);
		//list.insertAt(2, 10);
		//list.head.next.next.next.next.next.next.next=list.head;
		
		if(list.detectLoop()) {
			System.out.println("Loop found");
		}
		else {
			System.out.println("Loop not found.");
		}
		list.display();
	}

}
