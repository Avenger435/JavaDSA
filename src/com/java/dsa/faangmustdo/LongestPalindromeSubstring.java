/**
 * 
 */
package com.java.dsa.faangmustdo;

/**
 * 
 */
public class LongestPalindromeSubstring {

	public static void main(String args[]) {

		String s = "babad";

		String lps = longestPalindrome2(s);
		System.out.println("lps: " + lps);

	}

	public static String longestPalindrome2(String s) {

		// edge case:
		if (s == null || s.length() < 1) {
			return "";
		}

		int start = 0;
		int end = 0;
		for (int i = 0; i < s.length(); i++) {

			int len1 = expand(s, i, i); // even length
			int len2 = expand(s, i, i + 1);// odd length
			int len = Math.max(len1, len2); // take max

			// update the start and end based on i, if we find a better
			// length sub string.
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}

		}

		return s.substring(start, end + 1);
	}

	public static int expand(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}

	public static String longestPalindrome(String s) {
		// If the input string is null or empty, return an empty string
		if (s == null || s.length() < 1)
			return "";

		// Variables to track the start and end indices of the longest palindrome found
		int start = 0, end = 0;

		// Loop through each character in the string
		for (int i = 0; i < s.length(); i++) {
			// Check for odd-length palindrome centered at index i
			int len1 = expandAroundCenter(s, i, i);

			// Check for even-length palindrome centered between i and i+1
			int len2 = expandAroundCenter(s, i, i + 1);

			// Take the maximum length from both cases
			int len = Math.max(len1, len2);

			// If a longer palindrome is found, update start and end indices
			if (len > end - start) {
				// New start index based on current center and palindrome length
				start = i - (len - 1) / 2;

				// New end index based on current center and palindrome length
				end = i + len / 2;
			}
		}

		// Return the longest palindromic substring using updated start and end indices
		return s.substring(start, end + 1);
	}

	// Helper method to expand around a given center and return palindrome length
	private static int expandAroundCenter(String s, int left, int right) {
		// Expand while characters at left and right are equal and within bounds
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--; // Move left pointer outward
			right++; // Move right pointer outward
		}

		// Return the length of the palindrome found (adjusted for last expansion)
		return right - left - 1;
	}
}
