package com.java.dsa.faangmustdo;

public class LongestCommonSubsequence {

	public static void main(String[] args) {

		System.out.println("Case1: " + longestCommonSubsequence("abcde", "ace"));
		System.out.println("Case1 Optimized: " + longestCommonSubsequenceOptimized("abcde", "ace"));

	}

	public static int longestCommonSubsequence(String text1, String text2) {

		int m = text1.length();
		int n = text2.length();

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dp[i + 1][j + 1] = text1.charAt(i) == text2.charAt(j) ? 1 + dp[i][j]
						: Math.max(dp[i][j + 1], dp[i + 1][j]);
			}
		}

		return dp[m][n];
	}

	public static int longestCommonSubsequenceOptimized(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();
		int[] dp = new int[n + 1];
		for (int i = 0; i < m; i++) {
			int prev = 0;
			for (int j = 0; j < n; j++) {
				int temp = dp[j + 1];
				if (text1.charAt(i) == text2.charAt(j)) {
					dp[j + 1] = prev + 1;
				} else {
					dp[j + 1] = Math.max(dp[j + 1], dp[j]);
				}
				prev = temp;
			}
		}
		return dp[n];
	}
}