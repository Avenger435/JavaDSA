package com.java.dsa.linkedlist;

public class SwapNodePairsLL {

	public static void main(String[] args) {

		ListNode creatLinkedList = SinglyLinkedListUtil.createSinglyLinkedList(new int[] { 1, 4, 3, 2, 5, 2 });

		System.out.println(creatLinkedList);
		ListNode swapPairs2 = swapPairs(creatLinkedList);
		System.out.println("swapPairs2: " + swapPairs2);
	}

	private static ListNode swapPairs(ListNode head) {

		if (head == null)
			return head;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode prev = dummy;
	
		

		while (head != null && head.next != null) {

			ListNode first = head;
			ListNode second = head.next;

			prev.next = second;
			first.next = second.next;
			second.next = first;
			prev = first;
			head = first.next;
		}

		return dummy.next;
	}

	private static ListNode swapPairs2(ListNode head) {

		if (head == null)
			return head;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode prev = dummy;

		while (head != null && head.next != null) {
			ListNode first = head;
			ListNode second = head.next;

			// swap nodes;
			prev.next = second; // add the second node as first node dummy
			first.next = second.next; // make the first node of next pair as this pairs next
			second.next = first; // make previous node as next node.
			prev = first; // move prev forward
			head = first.next; // move head

		}

		return dummy.next;

	}

	private static ListNode reverseLL(ListNode head) {

		if (head == null)
			return null;

		ListNode prev = null;
		ListNode next = null;
		ListNode curr = head;
		while (curr != null) {
			next = curr.next; // store next node;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;

	}

}
