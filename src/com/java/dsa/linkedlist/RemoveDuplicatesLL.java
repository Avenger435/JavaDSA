package com.java.dsa.linkedlist;

public class RemoveDuplicatesLL {

	public static void main(String[] args) {

		ListNode creatLinkedList = SinglyLinkedListUtil.createSinglyLinkedList(new int[] { 1, 1, 1, 1, 1, 11 });

		System.out.println(creatLinkedList);
		ListNode removeElements = deleteDuplicates2(creatLinkedList);
		System.out.println("removeElements: " + removeElements);
	}

	private static ListNode deleteDuplicates2(ListNode head) {

		if (head == null)
			return null;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode prev = dummy;

		while (head != null) {
			if (head.next != null && head.val == head.next.val) {
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

	public static ListNode deleteDuplicates(ListNode head) {

		if (head == null)
			return null;

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
