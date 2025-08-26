package com.java.dsa.linkedlist;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 */
public class RemoveDuplicatesLL2 {

	public static void main(String[] args) {

		ListNode creatLinkedList = SinglyLinkedListUtil.createSinglyLinkedList(new int[] { 1, 2, 3, 3, 4, 4, 5 });

		System.out.println(creatLinkedList);
		ListNode removeElements = deleteDuplicates(creatLinkedList);
		System.out.println("removeElements: " + removeElements);
	}

	public static ListNode deleteDuplicates(ListNode head) {

		if (head == null)
			return head;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode prev = dummy;

		while (head != null) {
			// if we detect duplicates;
			if (head.next != null && head.val == head.next.val) {
				// skip nodes with same value
				while (head.next != null && head.val == head.next.val) {
					head = head.next;
				}
				prev.next = head.next;
			} else {
				prev = prev.next;
			}
			head = head.next;
		}
		return dummy.next;
	}
}
