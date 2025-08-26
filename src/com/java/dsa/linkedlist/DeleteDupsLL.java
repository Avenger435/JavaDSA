package com.java.dsa.linkedlist;

/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/submissions/1630134519/
 */
public class DeleteDupsLL {

	public static void main(String[] args) {

		int[] arr = new int[] { 1, 1, 1, 1 };
		ListNode singlyLinkedList = SinglyLinkedListUtil.createSinglyLinkedList(arr);

		System.out.println("singlyLinkedList: " + singlyLinkedList);
		System.out.println("findMid: " + deleteDuplicates(singlyLinkedList));

	}

	private static ListNode deleteDuplicates(ListNode head) {

		if (head == null)
			return head;

		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != null) {
			if (fast.val != slow.val) {
				slow.next = fast;
				slow = slow.next;
			}
			fast = fast.next;
		}

		slow.next = null;
		return head;
	}

}
