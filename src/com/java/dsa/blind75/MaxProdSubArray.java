package com.java.dsa.blind75;

public class MaxProdSubArray {

	public static void main(String[] args) {

		int[] nums1 = { 2, 3, -2, 4 };
		int[] nums2 = { -2, 0, -1 };
		int[] nums3 = { -3, -4 };

		System.out.println("Case1: " + maxProduct(nums1));

		System.out.println("Case2: " + maxProduct(nums2));

		System.out.println("Case3: " + maxProduct(nums3));
	}

	public static int maxProduct(int[] nums) {
		int maxProd = nums[0];
		int minProd = nums[0];
		int result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int prevMax = maxProd;
			int prevMin = minProd;
			maxProd = Math.max(nums[i], Math.max(prevMax * nums[i], prevMin * nums[i]));
			minProd = Math.min(nums[i], Math.min(prevMax * nums[i], prevMin * nums[i]));
			result = Math.max(result, maxProd);
		}
		return result;
	}

}
