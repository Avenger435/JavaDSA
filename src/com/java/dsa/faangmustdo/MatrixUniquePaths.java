package com.java.dsa.faangmustdo;

import java.util.Arrays;

public class MatrixUniquePaths {

	public static void main(String[] args) {

		System.out.println("Case 1 brute: " + uniquePaths(3, 7));
		System.out.println("Case 1 dpArr: " + uniquePathsDp(3, 7));
		System.out.println("Case 1 memo : " + uniquePathsMemo(3, 7));
	}

	public static int uniquePaths(int m, int n) {
		if (m == 1 && n == 1)
			return 1;
		if (m == 0 || n == 0)
			return 0;

		return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
	}

	public static int uniquePathsDp(int m, int n) {
		int[] dp = new int[n];
		Arrays.fill(dp, 1);

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[j] += dp[j - 1];
			}
		}
		return dp[n - 1];
	}

	public static int uniquePathsMemo(int m, int n) {
		int[][] memo = new int[m + 1][n + 1];
		return helper(m, n, memo);
	}

	public static int helper(int m, int n, int[][] memo) {
		if (m == 1 && n == 1)
			return 1;
		if (m == 0 || n == 0)
			return 0;

		memo[m][n] = helper(m - 1, n, memo) + helper(m, n - 1, memo);
		return memo[m][n];
	}
}
