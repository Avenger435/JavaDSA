package com.java.dsa.faangmustdo;

// JumpGame: Checks if you can reach the last index of the array
public class JumpGame {

	public static void main(String[] args) {
		// Test cases for canJump method
		JumpGame game = new JumpGame(); // Create an instance of JumpGame

		int[][] testCases = {
			{2,3,1,1,4}, // Should return true
			{3,2,1,0,4}, // Should return false
			{0},         // Should return true
			{1,0,1,0},   // Should return false
			{2,0,0},     // Should return true
			{1,2,3},     // Should return true
			{1,1,0,1},   // Should return false
			{2,5,0,0},   // Should return true
			{1,1,1,1,0}, // Should return true
			{1,0,0,0},   // Should return false
		};

		boolean[] expected = {
			true,   // Expected result for test case 1
			false,  // Expected result for test case 2
			true,   // Expected result for test case 3
			false,  // Expected result for test case 4
			true,   // Expected result for test case 5
			true,   // Expected result for test case 6
			false,  // Expected result for test case 7
			true,   // Expected result for test case 8
			true,   // Expected result for test case 9
			false   // Expected result for test case 10
		};

		// Loop through each test case
		for (int i = 0; i < testCases.length; i++) {
			boolean result = game.canJump(testCases[i]); // Call canJump for current test case
			System.out.println("Test " + (i+1) + ": Input=" + java.util.Arrays.toString(testCases[i]) +
				" | Expected=" + expected[i] + " | Result=" + result +
				(result == expected[i] ? " | PASS" : " | FAIL")); // Print result and pass/fail status
		}
	}

	// Determines if you can reach the last index of the array
	public boolean canJump(int[] nums) {
		int i=0; // Current index
		for(int reach=0;i< nums.length && i<=reach;i++ ) {
			// Update the furthest index that can be reached so far
			reach= Math.max(reach, i+ nums[i]);
		}
		// If we've reached the end, return true; otherwise, false
		return i== nums.length;
	}

}