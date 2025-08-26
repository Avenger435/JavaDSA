package com.java.dsa.linkedlist;

public class DeleteMid {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 5, 6 };
		ListNode singlyLinkedList = SinglyLinkedListUtil.createSinglyLinkedList(arr);

		System.out.println("singlyLinkedList: " + singlyLinkedList);
		System.out.println("findMid: " + deleteMid(singlyLinkedList));
	}

	private static ListNode deleteMid(ListNode head) {

		if (head == null)
			return head;

		ListNode fast = head;
		ListNode slow = head;
		ListNode prev = null;

		// we are finding the mid here, and assigning it to prev.
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;
			if (slow == fast)
				break;
		}

		// this is the crux. we are removing the mid node and pointing it to the next
		// node.
		if (prev != null)
			prev.next = slow.next;

		return head;

	}

}
