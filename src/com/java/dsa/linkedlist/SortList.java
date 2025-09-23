package com.java.dsa.linkedlist;

/**
 * Implementation of Merge Sort for Linked Lists
 * 
 * This class provides methods to sort a singly linked list using the merge sort algorithm.
 * It also includes a utility method to add nodes to a linked list.
 * 
 * Time Complexity: O(n log n) where n is the number of nodes
 * Space Complexity: O(log n) due to recursion stack
 * 
 * @author JavaDSA
 */
public class SortList {
    
    public static void main(String[] args) {
        // Test 1: Sort a predefined list
        System.out.println("=== Test 1: Sorting a predefined list ===");
        int[] arr = { -1, 5, 3, 4, 0 };
        ListNode head = new ListNode(arr[0]);
        head.next = new ListNode(arr[1]);
        head.next.next = new ListNode(arr[2]);
        head.next.next.next = new ListNode(arr[3]);
        head.next.next.next.next = new ListNode(arr[4]);
        System.out.println("Original: " + head);
        
        ListNode sorted = sortList(head);
        System.out.println("Sorted: " + sorted);
        
        // Test 2: Test push method
        System.out.println("\n=== Test 2: Testing push method ===");
        ListNode testList = null;
        testList = push(testList, 10);
        testList = push(testList, 5);
        testList = push(testList, 15);
        testList = push(testList, 1);
        System.out.println("List after pushing 10, 5, 15, 1: " + testList);
        
        ListNode sortedPushed = sortList(testList);
        System.out.println("Sorted pushed list: " + sortedPushed);
        
        // Test 3: Edge cases
        System.out.println("\n=== Test 3: Edge cases ===");
        System.out.println("Empty list: " + sortList(null));
        ListNode singleNode = new ListNode(42);
        System.out.println("Single node: " + sortList(singleNode));
        
        // Test 4: Additional edge cases
        System.out.println("\n=== Test 4: Additional edge cases ===");
        
        // Test duplicate values
        ListNode duplicates = new ListNode(5);
        duplicates.next = new ListNode(3);
        duplicates.next.next = new ListNode(5);
        duplicates.next.next.next = new ListNode(1);
        duplicates.next.next.next.next = new ListNode(3);
        System.out.println("Duplicates original: " + duplicates);
        System.out.println("Duplicates sorted: " + sortList(duplicates));
        
        // Test already sorted
        ListNode alreadySorted = new ListNode(1);
        alreadySorted.next = new ListNode(2);
        alreadySorted.next.next = new ListNode(3);
        alreadySorted.next.next.next = new ListNode(4);
        System.out.println("Already sorted: " + sortList(alreadySorted));
    }

    /**
     * Sorts a singly linked list using merge sort algorithm
     * 
     * @param head The head of the linked list to be sorted
     * @return The head of the sorted linked list
     */
    public static ListNode sortList(ListNode head) {
        // Base case: if head is null or single node, it's already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle node to split the list
        ListNode middle = getMiddle(head);
        ListNode secondHalf = middle.next;
        middle.next = null; // Split the list into two parts

        // Recursively sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(secondHalf);

        // Merge the two sorted halves
        return mergeTwoSortedLists(left, right);
    }

    /**
     * Adds a new node with the given value to the end of the linked list
     * @param head The head of the linked list
     * @param val The value to add
     * @return The head of the updated linked list
     */
    public static ListNode push(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        
        // If the list is empty, return the new node as head
        if (head == null) {
            return newNode;
        }
        
        // Traverse to the end of the list
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        
        // Add the new node at the end
        current.next = newNode;
        return head;
    }

    /**
     * Finds the middle node of a linked list using the two-pointer technique
     * 
     * @param head The head of the linked list
     * @return The middle node of the linked list
     */
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

    /**
     * Merges two sorted linked lists into one sorted linked list
     * @param list1 First sorted linked list
     * @param list2 Second sorted linked list
     * @return Merged sorted linked list
     */
    private static ListNode mergeTwoSortedLists(ListNode list1, ListNode list2) {
        // Use a dummy node to simplify the merge process
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Compare nodes from both lists and add the smaller one
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Add remaining nodes from either list
        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }

        return dummy.next;
    }

}
