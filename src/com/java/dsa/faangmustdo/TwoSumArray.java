/**
 * 
 */
package com.java.dsa.faangmustdo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 */
public class TwoSumArray {

	public static void main(String[] args) {

		int[] twoSum1 = twoSum(new int[] { 2, 7, 11, 15 }, 9);
		System.out.println(Arrays.toString(twoSum1));
	}

	public static int[] twoSum(int[] nums, int target) {

		int[] res = new int[2];
		Map<Integer, Integer> complimentMap = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int compliment = target - nums[i];
			if (!complimentMap.containsKey(nums[i])) {
				complimentMap.put(compliment, i);
			} else {
				res[0] = complimentMap.get(nums[i]);
				res[1] = i;
				break;
			}
		}

		return res;
	}

}
