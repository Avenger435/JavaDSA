package com.java.dsa.templates.sorting;

import java.util.Arrays;
import java.util.List;

/**
 * QuicksortTemplate provides a reusable template for implementing the Quicksort algorithm.
 *
 * Use cases:
 * - Sorting arrays of integers or other comparable types efficiently (average O(n log n) time)
 * - Partitioning arrays for selection algorithms (e.g., Quickselect for kth smallest/largest element)
 * - Teaching or demonstrating the divide-and-conquer sorting paradigm
 * - As a base for custom sorting logic where partitioning is required
 *
 * This template uses the Lomuto partition scheme.
 */
public class QuicksortTemplate {

	
	public static void main(String[] args) {
		// Example: Test sorting a List<Integer>
		List<Integer> list = Arrays.asList(7, 2, 5, 1, 9);
		// Convert List<Integer> to int[]
		int[] nums = list.stream().mapToInt(Integer::intValue).toArray();

		// Sort using QuicksortTemplate
		QuicksortTemplate sorter = new QuicksortTemplate();
		sorter.sort(nums, 0, nums.length - 1);

		// Print sorted array
		System.out.println("Sorted array: " + Arrays.toString(nums));
	}
	
	
    /**
     * Sorts the array in-place using the Quicksort algorithm.
     * @param nums The array to sort
     * @param lo   The starting index
     * @param hi   The ending index
     */
    void sort(int[] nums, int lo, int hi) {
        // Base case: if the subarray has one or no elements, it's already sorted
        if (lo >= hi) {
            return;
        }

        // Partition the array and get the pivot index
        int p = partition(nums, lo, hi);

        // Recursively sort elements before and after partition
        sort(nums, lo, p - 1);
        sort(nums, p + 1, hi);
    }

    /**
     * Partitions the array around a pivot such that elements less than the pivot
     * are on the left, and elements greater are on the right.
     * Uses Lomuto partition scheme.
     * @param nums The array to partition
     * @param lo   The starting index
     * @param hi   The ending index (pivot)
     * @return The index of the pivot after partition
     */
    int partition(int[] nums, int lo, int hi) {
        int pivot = nums[hi]; // Choose the last element as pivot
        int i = lo;
        for (int j = lo; j < hi; j++) {
            // If current element is less than pivot, swap it to the left partition
            if (nums[j] < pivot) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        // Place pivot in its correct position
        int temp = nums[i];
        nums[i] = nums[hi];
        nums[hi] = temp;
        return i;
    }

}