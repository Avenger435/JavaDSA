package com.java.dsa.linkedlist;

public class OddEvenNumberLL {

	public static void main(String[] args) {

		int[] arr = new int[] { 1, 2, 3, 4, 5 };

		ListNode head = SinglyLinkedListUtil.createSinglyLinkedList(arr);

		System.out.println("head: " + head);

		ListNode oddEvenNumber = oddEvenNumber(head);

		System.out.println("oddEvenNumber: " + oddEvenNumber);
	}

	private static ListNode oddEvenNumber(ListNode head) {

		if (head == null)
			return head;

		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenHead = even;// store even head.

		// Bisect the head into even and odd LL and then join them back.

		while (even != null && even.next != null) {
			//
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;

		}

		odd.next = evenHead;

		return head;

	}

}
