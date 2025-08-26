package com.java.dsa.google;

import java.util.Arrays;

import com.java.dsa.util.ComplexityProfiler;

public class GuessGameII {

	public static void main(String[] args) {

		long start = System.nanoTime();
		System.out.println("guessNumber: " + getMoneyAmountRec(10));
		long end = System.nanoTime();
		System.out.println("Recursion cost: " + (end - start) + "ns");

		long startMemo = System.nanoTime();
		System.out.println("Memo start");
		System.out.println("guessNumber: " + getMoneyAmountMemo(10));
		long endMemo = System.nanoTime();
		System.out.println("Memo cost: " + (endMemo - startMemo) + "ns");
		System.out.println("Memo End");

		long startDp = System.nanoTime();
		System.out.println("DP start");
		System.out.println("guessNumber: " + getMoneyAmountDp(10));
		long endDp = System.nanoTime();
		System.out.println("Dp cost: " + (endDp - startDp) + "ns");
		System.out.println("Dp End");

//		ComplexityProfiler.profile("Sum Function", 10, GuessGameII::getMoneyAmountDp);

	}

	// Memo approach
	public static int getMoneyAmountMemo(int n) {
		int[][] memo = new int[n + 1][n + 1];
		return costMemo(1, n, memo);
	}

	private static int costMemo(int start, int end, int[][] memo) {

		if (start >= end)
			return 0;
		if (memo[start][end] != 0)
			return memo[start][end];
		int minCost = Integer.MAX_VALUE;

		for (int x = start; x <= end; x++) {
			int left = costMemo(start, x - 1, memo);
			int right = costMemo(x + 1, end, memo);
			int worstCase = x + Math.max(left, right);
			minCost = Math.min(minCost, worstCase);
//			System.out.println("worstCase: " + worstCase + " minCost: " + minCost);
		}
		memo[start][end] = minCost;
//		System.out.println(Arrays.deepToString(memo));

		return minCost;
	}

	/**
	 * @param i
	 * @return
	 */
	private static int getMoneyAmountRec(int n) {

		return cost(0, n);
	}

	/**
	 * @param i
	 * @param n
	 * @return
	 */
	private static int cost(int start, int end) {
		if (start >= end) {
			return 0;
		}
		int minCost = Integer.MAX_VALUE;
		for (int x = start; x <= end; x++) {
			int left = cost(start, x - 1);
			int right = cost(x + 1, end);
			int worstCase = x + Math.max(left, right);
			minCost = Math.min(minCost, worstCase);
		}
		return minCost;
	}

	public static int getMoneyAmountDp(int n) {
		int[][] dp = new int[n + 2][n + 2];
		for (int len = 2; len <= n; len++) {
			for (int i = 1; i + len - 1 <= n; i++) {
				int j = i + len - 1;
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					int cost = k + Math.max(k - 1 >= i ? dp[i][k - 1] : 0, k + 1 <= j ? dp[k + 1][j] : 0);
					dp[i][j] = Math.min(dp[i][j], cost);
				}
			}
		}
		System.out.println(Arrays.deepToString(dp));
		return dp[1][n];
	}

}
