package com.java.dsa.linkedlist;

/*
 * https://leetcode.com/problems/odd-even-linked-list/submissions/1625427032/?envType=study-plan-v2&envId=leetcode-75
 */
public class PairSumLL {

	public static void main(String[] args) {

		int[] arr = { 7, 57, 13, 31, 17, 65, 32, 3, 97, 22, 7, 20, 69, 35, 69, 75, 13, 33, 50, 80, 64, 71, 15, 28, 2,
				27, 39, 48, 13, 22, 84, 5, 51, 46, 26, 78, 56, 63 };

		ListNode head = new ListNode(arr[0]);
		ListNode curr = head;

		for (int i = 1; i < arr.length; i++) {
			curr.next = new ListNode(arr[i]);
			curr = curr.next;
		}
		System.out.println("LL : " + head);

		System.out.println(pairSum(head));
	}

	public static int pairSum(ListNode head) {

		int maxPairSum = Integer.MIN_VALUE;
		if (head == null) {
			return 0;
		}

		if (head.next.next == null) {
			return head.val + head.next.val;
		}

		ListNode curr = head;
		ListNode mid = getMid(head);
		ListNode reverse = reverseLL(mid);

		System.out.println("mid: " + mid);
		System.out.println("reverse: " + reverse);
		while (reverse != null) {
			int sum = curr.val + reverse.val;
			System.err.println("curr.val : " + curr.val + " reverse.val " + reverse.val);
			System.out.println("sum : " + sum);
			if (sum >= maxPairSum) {
				maxPairSum = sum;
			}
			curr = curr.next;
			reverse = reverse.next;
		}

		return maxPairSum;
	}

	private static ListNode reverseLL(ListNode head) {

		ListNode prev = null;
		ListNode curr = head;

		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}

	public static ListNode getMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public static int optimalSolution(ListNode head) {

		int maxPairSum = 0;

		// find the mid of the LL
		ListNode fast = head;
		ListNode slow = head;
		ListNode prev = null;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;

			// reverse while finding mid
			ListNode temp = slow.next;
			slow.next = prev;
			prev = slow;
			slow = temp;
		}

		// Calculate max sum
		ListNode reverse = prev;
		while (slow != null) {
			maxPairSum = Math.max(maxPairSum, slow.val + reverse.val);
			slow = slow.next;
			reverse = reverse.next;
		}

		return maxPairSum;
	}

}
