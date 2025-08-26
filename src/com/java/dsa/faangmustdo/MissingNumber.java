/**
 * 
 */
package com.java.dsa.faangmustdo;

/**
 * 
 */
public class MissingNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int missing1 = findMissingNumber(new int[] { 3, 0, 1 });
		System.out.println("Missing1: " + missing1);

		int missing2 = findMissingNumber(new int[] { 0, 1 });
		System.out.println("Missing1: " + missing2);

	}

	/**
	 * @param is
	 * @return
	 */
	private static int findMissingNumber(int[] nums) {

		int n = nums.length;
		int sum = n * (n + 1) / 2;
		int currSum = 0;
		for (int num : nums) {
			currSum += num;
		}
		return sum - currSum;
	}

}
