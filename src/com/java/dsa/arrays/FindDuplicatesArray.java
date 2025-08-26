package com.java.dsa.arrays;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicatesArray {

	public static void main(String[] args) {

		int[] nums = { 1, 3, 4, 2, 2 };

		int duplicate = findDuplicate(nums);

		System.out.println("Duplicate: " + duplicate);

	}

	public static int findDuplicate(int[] nums) {

		int slow = nums[0];
		int fast = nums[nums[0]];

		// Detect the cycle
		while (true) {
			slow = nums[slow];
			fast = nums[nums[fast]];
			if (slow == fast)
				break;
		}

		// find the entry point of the cycle (duplicate number)
		slow = nums[0];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];

		}
		return fast; // or return slow, they're equal here.

	}
}
