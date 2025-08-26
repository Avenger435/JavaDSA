package com.java.dsa.linkedlist;

public class FindCycleLL {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 5, 6 };
		ListNode singlyLinkedList = SinglyLinkedListUtil.createSinglyLinkedList(arr);

		System.out.println("singlyLinkedList: " + singlyLinkedList);
		System.out.println("findMid: " + findCycle(singlyLinkedList));
	}

	private static boolean findCycle(ListNode head) {

		if (head == null)
			return false;

		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow)
				return true;
		}

		return false;
	}
}
