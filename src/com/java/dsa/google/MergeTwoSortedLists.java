package com.java.dsa.google;

public class MergeTwoSortedLists {

    public static void main(String[] args){
        ListNode list1= new ListNode(1);
        list1.next=new ListNode(2);
        list1.next.next= new ListNode(8);
        list1.next.next.next= new ListNode(4);

        ListNode list2= new ListNode(3);
        list2.next= new ListNode(5);
        list2.next.next= new ListNode(7);
        list2.next.next.next= new ListNode(10);
        ListNode result= mergeTwoLists(list1, list2);
        
        while(result!=null){
            System.out.print(result.val +" ");
            result= result.next;
        }
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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

        if (p1 != null) {
            result.next = p1;
        }
        if (p2 != null) {
            result.next = p2;
        }

        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
