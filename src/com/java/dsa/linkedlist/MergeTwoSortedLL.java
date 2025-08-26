package com.java.dsa.linkedlist;

/*
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLL {
	public static void main(String[] args) {

		int[] arrA = new int[] { 1, 2, 3, 4 };
		ListNode headA = SinglyLinkedListUtil.createSinglyLinkedList(arrA);

		int[] arrB = new int[] { 1, 1, 4, 5 };
		ListNode headB = SinglyLinkedListUtil.createSinglyLinkedList(arrB);

		System.out.println("HeadA : " + headA);
		System.out.println("HeadB : " + headB);
		System.out.println("findMid: " + mergeTwoLists(headA, headB));

	}

	private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

		// virtualNode
		ListNode dummy = new ListNode(-1);
		ListNode result = dummy;

		ListNode p1 = list1;
		ListNode p2 = list2;

		while (p1 != null && p2 != null) {
			if (p1.val > p2.val) {
				result.next = p2;
				p2 = p2.next;
			} else {
				result.next = p1;
				p1 = p1.next;
			}
			result = result.next;
		}

		if (p1 != null)
			result.next = p1;
		if (p2 != null)
			result.next = p2;

		return dummy.next;
	}

}
