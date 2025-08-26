package com.java.dsa.linkedlist;

public class IntersectionTwoLL {
	public static void main(String[] args) {
		int[] arrA = new int[] { 4, 1, 8, 4, 5 };
		ListNode headA = SinglyLinkedListUtil.createSinglyLinkedList(arrA);
		int[] arrB = new int[] { 5, 6, 1, 8, 4, 5 };
		ListNode headB = SinglyLinkedListUtil.createSinglyLinkedList(arrB);

		System.out.println("headA: " + headA);
		System.out.println("headB: " + headB);
		System.out.println("getIntersectionNode: " + getIntersectionNode(headA, headB));
	}

	private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		ListNode p1 = headA;
		ListNode p2 = headB;

		while (p1 != p2) {

			if (p1 == null) {
				p1 = headB;
			} else {
				p1 = p1.next;
			}

			if (p2 == null) {
				p2 = headA;
			} else {
				p2 = p2.next;
			}

		}
		return p1;
	}

}
