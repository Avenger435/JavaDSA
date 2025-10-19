package com.java.dsa.google;

import java.util.Arrays;

public class RotateArray {

	public static void main(String args[]) {

		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int k = 11;

		rotate(nums, k);
		System.out.println("RotatedArray: " + Arrays.toString(nums));

	}

	public static void rotate(int[] nums, int k) {

		k %= nums.length;
		System.out.println("k: " + k);
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);

	}

	private static void reverse(int[] nums, int l, int r) {
		while (l < r) {
			swap(nums, l++, r--);
		}
	}

	private static void swap(int[] nums, int l, int r) {

		int temp = nums[l];
		nums[l] = nums[r];
		nums[r] = temp;

	}
}
