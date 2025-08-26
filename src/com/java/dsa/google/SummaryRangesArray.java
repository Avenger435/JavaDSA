/**
 * 
 */
package com.java.dsa.google;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class SummaryRangesArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] nums = { 0, 1, 2, 4, 5, 7 };

		List<String> summaryRanges = summaryRanges(nums);
		System.out.println(summaryRanges);
	}

	public static List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<>();
		int n = nums.length;
		int start = 0;
		for (int index = 0; index < nums.length; index++) {
			// move index to the end of current range
			while (index + 1 < n && nums[index + 1] == nums[index] + 1) {
				index++;
			}
			// build the range string
			if (start == index) {
				result.add(String.valueOf(nums[start]));
			} else {
				result.add(nums[start] + "->" + nums[index]);
			}
			// set start to the beginning of the next range
			start = index + 1;
		}

		return result;

	}
}
