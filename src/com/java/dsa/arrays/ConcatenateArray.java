/**
 * 
 */
package com.java.dsa.arrays;

import java.util.Arrays;

/**
 * 
 * https://leetcode.com/problems/concatenation-of-array
 */
public class ConcatenateArray {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 4 };
		int[] concateArray = getConcatenation(nums);
		System.out.println(Arrays.toString(concateArray));
	}

	public static int[] getConcatenation(int[] nums) {

		// initialize res array with double the size of nums
		int[] res = new int[nums.length * 2];
		int length = nums.length;

		for (int index = 0; index < length; index++) {
			// normal copy
			res[index] = nums[index];
			// crux: now index+ length is the next half
			res[index + length] = nums[index];
		}
		return res;
	}

}
