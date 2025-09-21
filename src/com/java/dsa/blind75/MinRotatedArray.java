package com.java.dsa.blind75;

public class MinRotatedArray {

	public static void main(String[] args) {

		int[] nums1 = { 3, 4, 5, 1, 2 };
		int[] nums2 = { 4, 5, 6, 7, 0, 1, 2 };
		int[] nums3 = { 11, 13, 15, 17 };

		System.out.println("case1: " + findMin(nums1));
		System.out.println("case2: " + findMin(nums2));
		System.out.println("case3: " + findMin(nums3));
	}

	public static int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[right]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return nums[left];
	}
}
