package com.java.dsa.faangmustdo;

public class SearchRotatedSortedArray {

	public static void main(String[] args) {

//		int[] nums1 = { 4, 5, 6, 7, 0, 1, 2 };
//
//		int searchIndex1 = search(nums1, 1);
//		System.out.println("searchIndex: " + searchIndex1);
//
//		int[] nums2 = { 4, 5, 6, 7, 0, 1, 2 };
//		int searchIndex2 = search(nums2, 3);
//		System.out.println("searchIndex2: " + searchIndex2);

		int[] nums3 = { -5, -4, -3, -8, -7, -6 };
		int searchIndex3 = search(nums3, -6);
		System.out.println("searchIndex3: " + searchIndex3);
	}

	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;

		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] == target) {
				return mid;
			}
			// Check if left half is sorted
			if (nums[left] <= nums[mid]) {
				if (nums[left] <= target && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else { // Right half is sorted
				if (nums[mid] < target && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}

}