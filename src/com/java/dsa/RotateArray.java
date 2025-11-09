package com.java.dsa;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		System.out.println("Original Array: " + Arrays.toString(nums));

		rotate(nums, k);
		System.out.println("Rotated Array: " + Arrays.toString(nums));

	}

	public static void rotate(int[] nums, int k) {
		int n = nums.length;

		k %= n;
		reverse(nums, 0, n - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, n - 1);
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
