package com.java.dsa.arrays;
// Find the maximum subarray sum using Kadane's algorithm
public class FindMaxSubArraySum {

	public static void main(String[] args) {

		// int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		// // Output: 6

		int[] nums = { -1, -2, -3, -4, -5, -6 };
		// Output: 6



		int maxSubArray = maxSubArray(nums);
		System.out.println("maxSubArray: " + maxSubArray);
	}

	/**
	 * Finds the maximum subarray sum using Kadane's algorithm.
	 *
	 * @param nums the input array of integers
	 * @return the maximum subarray sum
	 */
	public static int maxSubArray(int[] nums) {
		// Edge case: if the array is null or empty, return 0
		if (nums == null || nums.length == 0)
			return 0;
		// Initialize max and current sum to the first element
		// of the array
		int max = nums[0], curr = nums[0];
		// Iterate through the array starting from the second element
		// and update the current sum and max sum accordingly
		for (int index = 1; index < nums.length; index++) {
			// Update current sum to be the maximum of the current element
			// or the current element plus the previous current sum
			curr = Math.max(nums[index], curr + nums[index]);
			// Update max sum if the current sum is greater
			// than the previous max sum
			max = Math.max(max, curr);
		}
		// Return the maximum subarray sum found
		// If all elements are negative, it will return the least negative number
		return max;
	}

}
