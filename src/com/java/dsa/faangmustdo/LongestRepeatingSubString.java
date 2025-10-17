package com.java.dsa.faangmustdo;

// This class provides a method to find the length of the longest substring
// where you can replace at most k characters to make all characters the same.
public class LongestRepeatingSubString {

	public static void main(String[] args) {
		// Example input string and k value
		String s = "ABAB";
		int k = 2;

		// Call the characterReplacement method and print the result
		int result = characterReplacement(s, k);
		System.out.println("Longest repeating character replacement: " + result);
	}

	/**
	 * Returns the length of the longest substring that can be obtained by replacing
	 * at most k characters so that all characters in the substring are the same.
	 * Uses a sliding window approach.
	 *
	 * @param s The input string consisting of uppercase English letters
	 * @param k The maximum number of allowed replacements
	 * @return The length of the longest valid substring
	 */
	public static int characterReplacement(String s, int k) {
		int maxCount = 0; // Tracks the max frequency of any character in the current window
		int[] count = new int[26]; // Frequency array for each character ('A'-'Z')

		int l = 0; // Left pointer for the sliding window
		int r = 0; // Right pointer for the sliding window

		// Expand the window by moving 'r' to the right
		for (r = 0; r < s.length(); ++r) {
			// Update the count for the current character and maxCount
			maxCount = Math.max(maxCount, ++count[s.charAt(r) - 'A']);
			// If the number of replacements needed exceeds k, shrink the window from the left
			if (maxCount + k < r - l + 1)
				--count[s.charAt(l++) - 'A'];
		}

		// The length of the longest valid window is r - l
		return r - l;
	}

}