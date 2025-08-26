package com.java.dsa.linkedlist;

public class RotateListLL {

	public static void main(String[] args) {

		ListNode creatLinkedList = SinglyLinkedListUtil.createSinglyLinkedList(new int[] { 1, 4, 3, 2, 5, 2 });

		System.out.println(creatLinkedList);
		ListNode rotateRight = rotateRight(creatLinkedList, 2);
		System.out.println("rotateRight: " + rotateRight);

	}

	public static ListNode rotateRight(ListNode head, int k) {
		ListNode newNode = new ListNode();
		newNode.next = head;
		if (head == null)
			return head;
		if (k == 0)
			return newNode;

		ListNode prev = null;
		ListNode curr = head;

		while (curr != null && curr.next != null) {
			prev = curr;
			curr = curr.next;
		}

		if (prev != null)
			prev.next = null;
		curr.next = head;

		return rotateRight(head, k--);
	}

	public static ListNode rotate(ListNode head) {

		if (head == null)
			return head;

		ListNode prev = null;
		ListNode curr = head;

		while (curr.next != null) {
			prev = curr;
			curr = curr.next;
		}

		prev.next = null;
		curr.next = head;

		return curr;
	}

}
