package com.java.dsa.neet150;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * This class provides methods to find the Kth largest element in an array.
 * It includes two approaches:
 * 1. Quick Select Algorithm
 * 2. Min-Heap Approach
 */
public class FindKthLargestElement {

    public static void main(String[] args) {

        // Test case 1: Find the 2nd largest element in the array
        int[] case1 = { 3, 2, 1, 5, 6, 4 };
        System.out.println("Case 1: " + findKthLargest(case1, 2));
    }

    /**
     * Finds the Kth largest element in the array using the Quick Select algorithm.
     *
     * @param nums The input array of integers.
     * @param k The Kth position to find (1-based index).
     * @return The Kth largest element in the array.
     */
    public static int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return quickSelect(list, k);
    }

    /**
     * Helper method to perform the Quick Select algorithm.
     *
     * @param nums The list of integers.
     * @param k The Kth position to find (1-based index).
     * @return The Kth largest element in the list.
     */
    public static int quickSelect(List<Integer> nums, int k) {
        int pivotIndex = new Random().nextInt(nums.size()); // Randomly select a pivot index

        int pivot = nums.get(pivotIndex); // Get the pivot value

        // Partition the list into three parts: left, mid, and right
        List<Integer> left = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int num : nums) {
            if (num > pivot) {
                left.add(num);
            } else if (num < pivot) {
                right.add(num);
            } else {
                mid.add(num);
            }
        }

        // Recursively find the Kth largest element in the appropriate partition
        if (k <= left.size()) {
            return quickSelect(left, k);
        }

        if (left.size() + mid.size() < k) {
            return quickSelect(right, k - left.size() - mid.size());
        }
        return pivot; // The pivot is the Kth largest element
    }

    /**
     * Finds the Kth largest element in the array using a Min-Heap.
     *
     * @param nums The input array of integers.
     * @param k The Kth position to find (1-based index).
     * @return The Kth largest element in the array.
     */
    public static int findKthLargestHeap(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>(); // Min-Heap to store the top K elements
        for (int num : nums) {
            minHeap.offer(num); // Add the current number to the heap
            while (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element if the heap size exceeds K
            }
        }
        return minHeap.peek(); // The root of the heap is the Kth largest element
    }

}