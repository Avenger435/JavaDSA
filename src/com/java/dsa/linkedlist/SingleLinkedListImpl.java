package com.java.dsa.linkedlist;

public class SingleLinkedListImpl {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println("Org list: ");
		list.printList();

		list.delete(2);
		System.out.println("After deleting 2:");
		list.printList();
	}

}

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}

}

class SinglyLinkedList {
	private Node head;

	// Add node at the end.
	public void add(int data) {
		Node newNode = new Node(data);

		// check if head is null -> Empty list -> add node to head.
		if (head == null) {
			head = newNode;
			return;
		}

		// Make current the head,
		Node current = head;
		// check if current's next is not null, move till null is found. set newnode
		// when null is found
		while (current.next != null) {
			current = current.next;
		}
		current.next = newNode;
	}

	// delete node by a value

	public void delete(int data) {

		// check if head is null, if so, then the list is null and return.
		if (head == null)
			return;

		// when head is not null, and head.data matches our input, just move the head to
		// next. thus unlinking the data node
		if (head.data == data) {
			head = head.next;
			return;
		}
		
		//set current to head.
		Node current = head;
		while (current.next != null && current.next.data != data) {
			current = current.next;
		}

		if (current.next != null) {
			current.next = current.next.next;
		}

	}

	// print the LL
	public void printList() {
		Node current = head;
		while (current != null) {
			System.out.println(current.data + "-> ");
			current = current.next;
		}
		System.out.println("null");
	}

}