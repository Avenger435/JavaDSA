package com.java.dsa.arrays;

/*
 * https://leetcode.com/problems/find-peak-element/
 */
public class FindPeakArray {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 1 };
		int peakElement = findPeakElement(nums);
		System.out.println("peakElement: " + peakElement);
	}

	public static int findPeakElement(int[] nums) {

		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[mid + 1]) {
				// You're on a descending slope,
				// peak must be on the left side (including mid)
				right = mid;
			} else {
				// You're on an ascending slope,
				// peak must be on the right side (excluding mid)
				left = mid + 1;
			}
		}
		return left;
	}

}
