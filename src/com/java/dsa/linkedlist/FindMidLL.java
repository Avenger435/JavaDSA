package com.java.dsa.linkedlist;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/submissions/1630130343/
 */
public class FindMidLL {

	public static void main(String[] args) {

		int[] arr = new int[] { 1, 2, 3, 5, 6 };
		ListNode singlyLinkedList = SinglyLinkedListUtil.createSinglyLinkedList(arr);

		System.out.println("singlyLinkedList: " + singlyLinkedList);
		System.err.println("findMid: " + findMid(singlyLinkedList));

	}

	public static ListNode findMid(ListNode head) {

		if (head == null)
			return head;

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				break;
			}
		}

		return slow;
	}
}
