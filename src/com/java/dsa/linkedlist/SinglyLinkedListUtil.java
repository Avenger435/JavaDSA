package com.java.dsa.linkedlist;

public class SinglyLinkedListUtil {

	public static void main(String[] args) {

		int[] arr = new int[] { 1, 2, 3, 5, 6 };
		ListNode singlyLinkedList = createSinglyLinkedList(arr);

		System.out.println(singlyLinkedList);

	}

	public static ListNode createSinglyLinkedList(int[] arr) {

		if (arr == null || arr.length == 0)
			return null;

		ListNode head = new ListNode(arr[0]);
		ListNode curr = head;

		for (int i = 1; i < arr.length; i++) {
			ListNode newNode = new ListNode(arr[i]);
			curr.next = newNode;
			curr = curr.next;
		}

		return head;

	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}

}