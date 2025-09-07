package com.java.dsa.blind75;

import java.util.HashSet;
import java.util.Set;

/**
 * This class provides a method to find the length of the longest consecutive
 * sequence in an array of integers. The method uses a HashSet to store unique
 * numbers and checks for consecutive sequences efficiently. The time complexity
 * of the solution is O(n) and the space complexity is also O(n). Example:
 * Input: nums = [100, 4, 200, 1, 3 , 2] Output: 4 Explanation: The longest
 * consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * 
 * @author javedk
 */
public class LongestConsecutiveSequence {

	public static void main(String[] args) {

		int[] nums = { 100, 4, 200, 1, 3, 2 };
		System.out.println(longestConsecutive(nums)); // 4

		int[] nums1 = { -1, 1, 0 };
		System.out.println(longestConsecutive(nums1)); // 3

		int[] nums2 = { 0 };
		System.out.println(longestConsecutive(nums2)); // 1

		// Edge cases
		int[] empty = {};
		System.out.println(longestConsecutive(empty)); // 0

		int[] single = { 5 };
		System.out.println(longestConsecutive(single)); // 1

		int[] duplicates = { 2, 2, 2 };
		System.out.println(longestConsecutive(duplicates)); // 1

		int[] allConsecutive = { 1, 2, 3, 4, 5 };
		System.out.println(longestConsecutive(allConsecutive)); // 5

		int[] noConsecutive = { 10, 30, 50 };
		System.out.println(longestConsecutive(noConsecutive)); // 1

		int[] negatives = { -2, -1, 0, 1 };
		System.out.println(longestConsecutive(negatives)); // 4

		int[] largeGaps = { 1, 100, 200, 300 };
		System.out.println(longestConsecutive(largeGaps)); // 1

		int[] posNeg = { -3, -2, -1, 0, 1, 2, 3 };
		System.out.println(longestConsecutive(posNeg)); // 7

		int[] minMax = { Integer.MIN_VALUE, Integer.MAX_VALUE };
		System.out.println(longestConsecutive(minMax)); // 1

		int[] twoSeq = { 1, 2, 3, 10, 11, 12 };
		System.out.println(longestConsecutive(twoSeq)); // 3

		int[] overlap = { 1, 2, 2, 3 };
		System.out.println(longestConsecutive(overlap)); // 3

		int[] negPosNotConsecutive = { -10, 10 };
		System.out.println(longestConsecutive(negPosNotConsecutive)); // 1

		int[] zeroNeg = { 0, -1, -2, -3 };
		System.out.println(longestConsecutive(zeroNeg)); // 4

		System.out.println(longestConsecutive(null)); // 0
	}

	public static int longestConsecutive(int[] nums) {

		// Initialize max to the smallest integer value
		int max = Integer.MIN_VALUE;
		// Initialize min to the largest integer value
		int min = Integer.MAX_VALUE;
		// Counter for current consecutive sequence
		int count = 0;
		// Variable to store the longest sequence found
		int longest = 0;
		// Find the minimum and maximum values in the array
		for (int num : nums) {
			max = Math.max(max, num); // Update max if current num is greater
			min = Math.min(min, num); // Update min if current num is smaller
		}

		// If the range is not too large, use a boolean array for fast lookup
		if (max < 100000) {
			// Create a boolean array to mark presence of numbers
			boolean b[] = new boolean[max - min + 1];

			// Mark the presence of each number in the boolean array
			for (int i : nums) {
				b[i - min] = true;
			}

			// Iterate through the boolean array to find the longest consecutive sequence
			for (boolean val : b) {
				if (val) {
					count++; // Increment count if current value is present
				} else {
					longest = Math.max(count, longest); // Update longest if needed
					count = 0; // Reset count for next sequence
				}

			}
			// Final check in case the longest sequence is at the end
			longest = Math.max(count, longest);
		} else {
			// If the range is too large, use a HashSet for efficient lookup
			Set<Integer> set = new HashSet<>();
			// Add all numbers to the set
			for (int num : nums) {
				set.add(num);
			}
			// Iterate through the set to find the start of each sequence
			for (int num : set) {
				if (!set.contains(num - 1)) { // Only start from the beginning of a sequence
					int temp = num;
					while (set.contains(temp)) { // Count the length of the sequence
						count++;
						temp++;
					}
					longest = Math.max(count, longest); // Update longest if needed
					count = 0; // Reset count for next sequence
				}
			}
		}

		// Return the length of the longest consecutive sequence found
		return longest;

	}

	public static int longestConsecutive1(int[] nums) {

		int max = 0;

		Set<Integer> set = new HashSet<>();

		for (int num : nums) {
			set.add(num);
		}

		for (int i = 0; i < nums.length; i++) {
			int count = 1;
			// look left
			int num = nums[i];
			while (set.contains(--num)) {
				count++;
				set.remove(num); // Remove to prevent reprocessing
			}

			num = nums[i];
			// look right
			while (set.contains(++num)) {
				count++;
				set.remove(num);// Remove to prevent reprocessing
			}

			max = Math.max(max, count);

		}
		return max;
	}
}