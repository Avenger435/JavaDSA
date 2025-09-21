package com.java.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {

		// Test case 1: Standard 4Sum example
		int[] nums1 = { 1, 0, -1, 0, -2, 2 };
		int target1 = 0;

		// Test case 2: Edge case with large numbers and duplicates
		int[] nums2 = { 0, 0, 0, 1000000000, 1000000000, 1000000000, 1000000000 };
		int target2 = 1000000000;

		int[] nums3 = { 1000000000, 1000000000, 1000000000, 1000000000 };
		int target3 = -294967296;

		System.out.println(fourSum(nums1, target1));

		System.out.println(fourSum(nums2, target2));
		System.out.println(fourSum(nums3, target3));

	}

	/**
	 * Finds all unique quadruplets in the array which sum up to the given target.
	 * Uses sorting, two nested loops, and a two-pointer approach for efficiency.
	 * Handles duplicates and large numbers correctly.
	 *
	 * @param nums   The input array
	 * @param target The target sum
	 * @return List of unique quadruplets that sum to target
	 */
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums); // Sort the array to handle duplicates and use two-pointer
		int n = nums.length;
		// First loop: pick the first number
		for (int i = 0; i < n - 3; i++) {
			// Skip duplicate values for the first number
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			// Second loop: pick the second number
			for (int j = i + 1; j < n - 2; j++) {
				// Skip duplicate values for the second number
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;
				int left = j + 1, right = n - 1;
				// Two-pointer approach for the remaining two numbers
				while (left < right) {
					// Use long to avoid integer overflow
					long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
					if (sum == target) {
						// Found a valid quadruplet
						res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
						left++;
						right--;
						// Skip duplicates for the third number
						while (left < right && nums[left] == nums[left - 1])
							left++;
						// Skip duplicates for the fourth number
						while (left < right && nums[right] == nums[right + 1])
							right--;
					} else if (sum < target) {
						// Need a larger sum, move left pointer
						left++;
					} else {
						// Need a smaller sum, move right pointer
						right--;
					}
				}
			}
		}
		return res;
	}
}