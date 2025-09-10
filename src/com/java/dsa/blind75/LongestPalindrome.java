/**
 * 
 */
package com.java.dsa.blind75;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/?envType=problem-list-v2&envId=oizxjoit
 */
public class LongestPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String inputString = "babad";
		String longestPalindrome = longestPalindrome(inputString);
		System.out.println(longestPalindrome);

	}

	public static String longestPalindrome(String s) {
		if (s == null || s.length() <1) {
			return "";
		}

		int start = 0;
		int end = 0;

		for (int i = 0; i < s.length(); i++) {

			int len1 = expand(s, i, i);
			int len2 = expand(s, i, i + 1);
			int len = Math.max(len1, len2);

			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}

		return s.substring(start, end+1);
	}

	
	public static int expand(String s, int left, int right) {
		while(left >=0 && right < s.length() && s.charAt(right)== s.charAt(left)) {
			left--;
			right++;
		}
		return right-left-1;
	}

	/**
	 * Easiest approach: Expand Around Center
	 * For each character (and each pair), expand outwards to find the longest palindrome.
	 */
	public static String longestPalindromeExpandCenter(String s) {
		if (s == null || s.length() < 1) return "";
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expand(s, i, i); // Odd length
			int len2 = expand(s, i, i + 1); // Even length
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}
}