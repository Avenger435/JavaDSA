package com.java.dsa.arrays;

import java.util.Arrays;

public class MoveZerosArray {

	public static void main(String[] args) {

		int[] nums = {};
		System.out.println(Arrays.toString(nums));
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}

	public static void moveZeroes(int[] nums) {
		if (nums.length == 0)
			return;

		int n = nums.length;
		int insertPos = 0;

		nums[insertPos] = nums[0];

		for (int i = 0; i < n; i++) {
			if (nums[i] != 0) {
				nums[insertPos] = nums[i];
				insertPos++;
			}
		}

		for (int i = insertPos; i < n; i++) {
			nums[i] = 0;
		}

	}

}
