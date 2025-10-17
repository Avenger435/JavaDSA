package com.java.dsa.faangmustdo;

public class HouseRobber {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 1 };
		System.out.println("Max robbed amount: " + rob(nums));
	}

	public static int rob(int[] nums) {
		int maxRobbedAmount = 0;

		int prev1 = 0; // Max amount robbed up to the previous house
		int prev2 = 0; // Max amount robbed up to the house before the previous
		for (int num : nums) {
			int temp = prev1;
			prev1 = Math.max(prev2 + num, prev1);
			prev2 = temp;
		}
		maxRobbedAmount = prev1;
		
		return maxRobbedAmount;
	}

}
