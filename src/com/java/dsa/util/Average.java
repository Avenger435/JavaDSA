package com.java.dsa.util;

public class Average {

	// this class should not be instantiated.
	private Average() {
	}

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4, 5 };

		System.out.println(" " + average(nums));

	}

	public static double average(int[] nums) {

		int count = 0;
		double sum = 0.0;

		for (int i : nums) {			
			sum += i;
		}
		return sum / nums.length;
	}
}
