package com.java.dsa.linkedlist;

public class SortList {

	public static void main(String[] args) {
		int[] arr = { -1, 5, 3, 4, 0 };
		ListNode head = new ListNode(arr[0]);
		head.next = new ListNode(arr[1]);
		head.next.next = new ListNode(arr[2]);
		head.next.next.next = new ListNode(arr[3]);
		head.next.next.next.next = new ListNode(arr[4]);
		System.out.println(head);
		ListNode sortList = sortList(head);
		System.out.println("sortList: " + sortList);
	}

	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode mid = getMiddle(head);
		ListNode rightHead = mid.next;
		mid.next = null;

		ListNode left = sortList(head);
		ListNode right = sortList(rightHead);

		return merge(left, right);
	}

	public static ListNode merge(ListNode p1, ListNode p2) {

		ListNode dummy = new ListNode(-1);
		ListNode result = dummy;
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

	public static ListNode getMiddle(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;

	}

}
