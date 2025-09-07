package com.java.dsa.googletop50;

public class WildcardMatching {

	public static void main(String[] args) {

		// Input string to match
		String s = "a";
		// Pattern string with wildcards
		String p = "aa";

		// Call the isMatch function to check if s matches p
		boolean matchCase1 = isMatch(s, p);

		// Print the result of the match
		System.out.println(matchCase1);

	}

	// Function to check if string s matches pattern p with wildcards
	public static boolean isMatch(String s, String p) {

		int m = s.length(); // Length of input string
		int n = p.length(); // Length of pattern string

		// dp[i][j] will be true if first i chars in s match first j chars in p
		boolean[][] dp = new boolean[m + 1][n + 1];
		// base case 1: empty string matches empty pattern
		dp[0][0] = true;

		// base case 2: initialize dp for patterns starting with '*', '**', etc.
		for (int j = 1; j <= n; j++) {
			// If current pattern char is '*', it can match empty string
			if (p.charAt(j - 1) == '*') {
				dp[0][j] = dp[0][j - 1];
			}
		}

		// Fill the dp table for all other cases
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				char pc = p.charAt(j - 1); // Current pattern character
				char sc = s.charAt(i - 1); // Current string character

				if (pc == '*') {
					// '*' can match zero chars (dp[i][j-1]) or one/more chars (dp[i-1][j])
					dp[i][j] = dp[i][j - 1] || dp[i - 1][j];

				} else if (pc == '?' || pc == sc) {
					// '?' matches any single char, or exact match
					dp[i][j] = dp[i - 1][j - 1];
				}

			}
		}

		// Return if full string matches full pattern
		return dp[m][n];
	}
}