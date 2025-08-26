package com.java.dsa.linkedlist;

public class SingLL {

	public static void main(String[] args) {
		SinglyLL list = new SinglyLL();
		list.printLL();
		list.add(1);
		list.add(2);
		list.add(3);
		list.printLL();
		list.delete(3);
		System.out.println();
		list.printLL();

	}

}

class Nodal {
	int data;
	Nodal next;

	Nodal(int data) {
		this.data = data;
		this.next = null;
	}

	@Override
	public String toString() {
		return "Nodal [data=" + data + ", next=" + next + "]";
	}

}

class SinglyLL {
	private Nodal head;

	// pring method.
	public void printLL() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		Nodal current = head;
		while (current != null) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.print("null");
	}

	// add data;
	public void add(int data) {
		Nodal newNodal = new Nodal(data);
		System.out.println(newNodal);
		if (head == null) {
			head = newNodal;
			return;
		}

		Nodal current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = newNodal;
	}

	// delete
	public void delete(int data) {

		if (head == null) {
			System.out.println("List is empty");
		}

		if (head.data == data) {
			head = head.next;
			return;
		}
		Nodal current = head;
		while (current.next != null && current.next.data != data) {
			current = current.next;
		}

		if (current.next != null) {
			current.next = current.next.next;
		}
	}
}
