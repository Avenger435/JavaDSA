package com.java.dsa.faangmustdo;

public class LongestPalindromeSubsManacher {

	public static void main(String[] args) {

		String s = "badad";
		String lps = longestPalindromeManachers(s);
		System.out.println("lps: " + lps);

	}

	private static String longestPalindromeManachers(String s) {
		// edge case
		if (s == null || s.length() == 0)
			return "";

		// Preprocess: Insert '#' between chars at the ends.
		StringBuilder t = new StringBuilder("^");
		for (char c : s.toCharArray()) {
			t.append("#").append(c);
		}
		t.append("$");

		char[] arr = t.toString().toCharArray();

		int[] p = new int[arr.length];
		int center = 0, right = 0;
		int maxLen = 0, centerIndex = 0;

		for (int i = 1; i < arr.length - 1; i++) {
			int mirror = 2 * center - i;
			if (i < right) {
				p[i] = Math.min(right - i, p[mirror]);
			}

			// Expand around center i
			while (arr[i + (1 + p[i])] == arr[i - (1 + p[i])]) {
				p[i]++;
			}

			// update center
			if (i + p[i] > right) {
				center = i;
				right = i + p[i];
			}

			// track max palindrome
			if (p[i] > maxLen) {
				maxLen = p[i];
				centerIndex = i;
			}
		}
		// Extract the LPS from original string
		int start = (centerIndex - maxLen) / 2;
		return s.substring(start, start + maxLen);
	}

}
