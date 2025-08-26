package com.java.dsa.linkedlist;

/**
 * https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/
 */
public class PairSumLinkedList {
	public static void main(String[] args) {

		int[] arrA = new int[] { 5, 4, 3, 2, 1 };
		ListNode headA = SinglyLinkedListUtil.createSinglyLinkedList(arrA);

		System.out.println("HeadA : " + headA);
		System.out.println("findMid: " + twinPairSum(headA));

	}

	private static int twinPairSum(ListNode head) {

		int maxPairSum = 0;

		if (head == null)
			return 0;

		ListNode fast = head;
		ListNode slow = head;
		ListNode prev = null;

		while (fast != null && fast.next != null) {

			fast = fast.next.next;
			ListNode temp = slow.next;
			slow.next = prev;
			prev = slow;
			slow = temp;

		}

		// calculate max

		ListNode reverse = prev;

		while (slow != null && reverse != null) {
			maxPairSum = Math.max(maxPairSum, slow.val + reverse.val);
			slow = slow.next;
			reverse = reverse.next;
		}

		return maxPairSum;
	}
}
