package com.java.dsa.linkedlist;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
public class AddTwoNumbersLL {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(9);
		System.out.println(l1);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		l2.next.next.next = new ListNode(9);

		System.out.println(addTwoNumbers(l1, l2));

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		System.out.println("reversed1: " + l1);
		System.out.println("reversed2: " + l2);

		ListNode sumList = new ListNode(0);
		ListNode curr = sumList;
		int carry = 0;
		while (l1 != null || l2 != null || carry != 0) {
			int sum = carry;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}

			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
		}
		return sumList.next;

	}

	public static ListNode reverseLL(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;

		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}

}



class SingleLinkList {
	private ListNode head;

	public void add(int data) {
		ListNode newNode = new ListNode(data);
		if (head == null) {
			head = newNode;
			return;
		}
		ListNode current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = newNode;
	}

	public void delete(int data) {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		if (head.val == data) {
			head = head.next;
			return;
		}

		ListNode current = head;
		while (current.next != null && current.next.val != data) {
			current = current.next;
		}

		if (current.next != null) {
			current.next = current.next.next;
		}

	}

	public void printList() {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + " -> ");
			current = current.next;
		}
		System.out.print("null");
	}

}