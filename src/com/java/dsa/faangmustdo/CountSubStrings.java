package com.java.dsa.faangmustdo;

public class CountSubStrings {

	public static void main(String[] args) {
		// Test the countSubstrings method with example input
		System.out.println("Count: " + countSubstrings("abc"));
	}

	/**
	 * Counts the number of palindromic substrings in the given string.
	 * @param s The input string
	 * @return The total count of palindromic substrings
	 */
	private static int countSubstrings(String s) {
		int ans = 0;

		// For each character, try to extend palindromes of odd and even length
		for (int i = 0; i < s.length(); i++) {
			ans += extendPalindromes(s, i, i);     // Odd length palindromes
			ans += extendPalindromes(s, i, i + 1); // Even length palindromes
		}

		return ans;
	}

	/**
	 * Helper method to count palindromic substrings centered at indices l and r.
	 * Expands outwards as long as the substring remains a palindrome.
	 * @param s The input string
	 * @param l Left index
	 * @param r Right index
	 * @return Number of palindromic substrings found
	 */
	private static int extendPalindromes(final String s, int l, int r) {
		int count = 0;
		// Expand around the center while the substring is a palindrome
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			count++;
			--l;
			++r;
		}
		return count;
	}

}