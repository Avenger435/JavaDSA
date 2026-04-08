package com.java.dsa.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class MaxSubarraySum {

	public static void main(String[] args) {

		int[] nums = { 1, -1, 5, -2, 3 };
		int k = 3;

		int[] nums1 = { -2, -1, 2, 1 };
		int k1 = 1;

		MaxSubarraySum mss = new MaxSubarraySum();
		int result = mss.maxSubArrayLen(nums, k);
		System.out.println("The maximum length of a subarray with sum " + k + " is: " + result);

		int result1 = mss.maxSubArrayLen(nums1, k1);
		System.out.println("The maximum length of a subarray with sum " + k1 + " is: " + result1);
	}

	public int maxSubArrayLen(int[] nums, int k) {
		int ans = 0;
		int n = nums.length;
		int prefix = 0;
		Map<Integer, Integer> prefixToIndex = new HashMap<>();
		prefixToIndex.put(0, -1);

		for (int i = 0; i < n; i++) {
			prefix += nums[i];
			int target = prefix - k;
			if (prefixToIndex.containsKey(target))
				ans = Math.max(ans, i - prefixToIndex.get(target));
			prefixToIndex.putIfAbsent(prefix, i);
		}
		System.out.println(prefixToIndex);
		return ans;
	}
}
