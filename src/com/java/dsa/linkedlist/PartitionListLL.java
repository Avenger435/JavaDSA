package com.java.dsa.linkedlist;

public class PartitionListLL {

	public static void main(String[] args) {

		ListNode creatLinkedList = SinglyLinkedListUtil.createSinglyLinkedList(new int[] { 1, 4, 3, 2, 5, 2 });

		System.out.println(creatLinkedList);
		ListNode partition = partition(creatLinkedList, 3);
		System.out.println("partition: " + partition);

	}

	private static ListNode partition(ListNode head, int x) {

		if (head == null)
			return head;

		ListNode small = new ListNode(-1);
		ListNode large = new ListNode(-1);
		ListNode smallHead = small;
		ListNode largeHead = large;

		while (head != null) {
			if (head.val >= x) {
				large.next = head;
				large = large.next;
			} else {
				small.next = head;
				small = small.next;
			}
			head = head.next;
		}
		large.next = null;
		small.next = largeHead.next;
		return smallHead.next;
	}

}
