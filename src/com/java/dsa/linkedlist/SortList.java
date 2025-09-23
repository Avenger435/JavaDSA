package com.java.dsa.linkedlist;

public class SortList {
    
    public static void main(String[] args) {
        int[] arr = { -1, 5, 3, 4, 0 };
        ListNode head = new ListNode(arr[0]);
        head.next = new ListNode(arr[1]);
        head.next.next = new ListNode(arr[2]);
        head.next.next.next = new ListNode(arr[3]);
        head.next.next.next.next = new ListNode(arr[4]);
        System.out.println("Original: " + head);
        
        ListNode sorted = sortList(head);
        System.out.println("Sorted: " + sorted);
    }

    public static ListNode sortList(ListNode head) {

        if (head == null)
            return head;

        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        ListNode middle= getMiddle(head);
        System.out.println("Middle: "+middle);


        return dummy.next;

    }

    public static void push(int val){
        ListNode newNode= new ListNode(val);
        newNode= newNode.next;
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
