/**
 * 
 */
package com.java.dsa.google;

import java.util.Arrays;

/**
 * 
 */
public class MoveZerosArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] nums = { 0, 1, 0, 3, 12 };
		moveZeroes(nums);

	}

	public static void moveZeroes(int[] nums) {

		if (nums.length == 0)
			return;

		int n = nums.length;
		int insertPosition = 0;

		nums[insertPosition] = nums[0];

		for (int i = 0; i < n; i++) {
			if (nums[i] != 0) {
				nums[insertPosition] = nums[i];
				insertPosition++;
			}
		}

		for (int i = insertPosition; i < n; i++){
			nums[i] = 0;
		}

		System.out.println(Arrays.toString(nums));
	}

}
