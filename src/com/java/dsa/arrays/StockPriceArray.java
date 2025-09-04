package com.java.dsa.arrays;


/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class StockPriceArray {

	public static void main(String[] args) {
//		int[] prices = { 7, 1, 5, 3, 6, 4 };
//		int[] prices = { 7, 6, 4, 3, 1 };
		int[] prices = {};
		int maxProfit = maxProfit(prices);
		System.out.println("maxProfit: " + maxProfit);
	}

	public static int maxProfit(int[] prices) {

		int minSoFar = Integer.MAX_VALUE;
		int profitToday = 0;
		int maxProfit = 0;
		for (int price : prices) {
			// keep track of the minimum so far
			minSoFar = Math.min(price, minSoFar);
			// Calculate today's profit
			profitToday = price - minSoFar;
			// compare with Max profit and update
			maxProfit = Math.max(profitToday, maxProfit);
		}

		return maxProfit;
	}

}
