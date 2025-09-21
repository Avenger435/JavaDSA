package com.java.dsa.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScratchPad {

	public static void main(String[] args) {

		// Test case 1: Standard 4Sum example
		int[] nums1 = { 1, 0, -1, 0, -2, 2 };
		int target1 = 0;

		// Test case 2: Edge case with large numbers and duplicates
		int[] nums2 = { 0, 0, 0, 1000000000, 1000000000, 1000000000, 1000000000 };
		int target2 = 1000000000;
		
		int[] nums3= {1000000000,1000000000,1000000000,1000000000};
		int target3= -294967296;

		System.out.println(fourSum(nums1, target1));

		System.out.println(fourSum(nums2, target2));
		
		System.out.println(fourSum(nums3,target3));
	}

	private static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		int n = nums.length;

		for (int i = 0; i < n - 3; i++) {
			
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			
			for (int j = i + 1; j < n - 2; j++) {
				
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;

				int left = j + 1;
				int right = n - 1;

				while (left < right) {
					long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

					if (sum == target) {
						result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

						left++;
						right--;
						while (left < right && nums[left] == nums[left - 1])
							left++;
						while (left < right && nums[right] == nums[right + 1])
							right--;

					} else if (sum < target) {
						left++;
					} else {
						right--;
					}
				}
			}
		}

		return result;
	}

}
