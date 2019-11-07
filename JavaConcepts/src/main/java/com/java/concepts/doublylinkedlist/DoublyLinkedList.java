package com.java.concepts.doublylinkedlist;

public class DoublyLinkedList {

	Node head;

	public void pushAtStart(int data) {

		// 1. create new node
		// 2. allocate the node
		Node newNode = new Node(data);

		// 3. make the next of new node as head and prev is as null
		newNode.next = head;
		newNode.prev = null;

		// 4. change the head of prev node to new node
		if (head != null) {
			head.prev = newNode;
		}

		// 5. move the head to point to new node
		head = newNode;
	}

	public void insertAfterNode(Node prevNode, int data) {

		if (prevNode == null) {
			System.out.println("PrevNode can't be null");
		}

		// 1. Create & allocate new node
		Node newNode = new Node(data);

		// 2. make the next of new node to next of prev node
		newNode.next = prevNode.next;

		// 3. make next of prev node to new node
		prevNode.next = newNode;

		// 4. make prev of new node as prev node
		newNode.prev = prevNode;

		// 5. change the prev of new node's next node
		if (newNode.next != null) {
			newNode.next.prev = newNode;
		}
	}

	public void insertNodeAtEnd(int data) {

		// 1. Create & allocate new node
		Node newNode = new Node(data);
		Node endNode = head;

		// 2. Check if linked list is null then make new node as first node
		if (head == null) {
			newNode.prev = null;
			head = newNode;
			return;
		}

		// 3. find out the last node
		while (endNode.next != null) {
			endNode = endNode.next;
		}

		// 4. make next as null of new node
		newNode.next = null;

		// 5. make endNode prev of newNode
		newNode.prev = endNode;

		// 6. make new node as next of end node
		endNode.next = newNode;
	}

	public void insertBeforeNode(Node nextNode, int data) {

		// 1. check if nextNode is null
		if (nextNode == null) {
			System.out.println("Given next node can't be null");
			return;
		}
		// 2. create and allocate data as new node
		Node newNode = new Node(data);

		// 3. make next node to next of new node
		newNode.next = nextNode;

		// 4. make prev of nextNode to prev of newNode
		newNode.prev = nextNode.prev;

		// 5. make new node to prev of next node
		nextNode.prev = newNode;

		// 6. if prev of new node is not null then make it next of its prev node
		if (newNode.prev != null) {
			newNode.prev.next = newNode;
		} else {
			// 7. if null then make new node as head node
			head = newNode;
		}
	}

	public void printDublyList() {

		Node lastNode = head;

		System.out.println("Forward direction traversal");
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}

		System.out.println("\nReverse direction traversal");
		// get the last node
		while (lastNode.next != null) {
			lastNode = lastNode.next;
		}

		// Start traversal from last
		while (lastNode != null) {
			System.out.print(lastNode.data + " ");
			lastNode = lastNode.prev;
		}
	}

	public void deleteNodeAt(int position) {
		// 1. head is null
		if (head == null) {
			return;
		}

		// 2. to delete at 1st position
		if (position == 1) {
			if (head.next != null) {
				head.next.prev = null;
				return;
			}
		}

		// 3. to delete node apart from start or end
		Node node = head;
		while (node != null && position > 1) {
			node = node.next;
			position--;
		}
		
		if (node == null) {
			System.out.println("Node doesn't exists at given position.");
			return;
		}
		
		if (node.next != null) {
			node.next.prev = node.prev;

		}
		node.prev.next = node.next;
	}
}
