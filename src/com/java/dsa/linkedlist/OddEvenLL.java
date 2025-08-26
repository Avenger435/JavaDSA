package com.java.dsa.linkedlist;

/**
 * https://leetcode.com/problems/odd-even-linked-list/submissions/1625427032/?envType=study-plan-v2&envId=leetcode-75
 */
public class OddEvenLL {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

		System.out.println(l1);

		System.out.println(oddEvenList(l1));

	}

	public static ListNode oddEvenList(ListNode head) {

		if (head == null) {
			return head;
		}

//since head is odd, initialise odd and even
		ListNode odd = head;
		ListNode even = head.next;
//		Maintain evenhead to link later
		ListNode evenHead = head.next;

		// while we have even indices, we swap,
		while (even != null && even.next != null) {
			odd.next = odd.next.next;
			odd = odd.next;
			even.next = even.next.next;
			even = even.next;
		}
		// link odd to even
		odd.next = evenHead;

		return head;
	}

}
