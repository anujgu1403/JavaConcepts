package com.java.concepts.doublylinkedlist;

public class DoublyLinkedListRunner {
	
	public static void main(String[] args) {
		DoublyLinkedList list=new DoublyLinkedList();
		list.pushAtStart(11);
		list.pushAtStart(19);
		list.pushAtStart(71);
		list.pushAtStart(13);
		list.pushAtStart(51);
		list.deleteNodeAt(8);
		
		list.printDublyList();
		
		
	}
}
