/**
 * 
 */
package com.java.dsa.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/description/
 * 
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it as shown:
 * 
 * 
 */
public class PascalsTriangleArrayDP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numRows = 5;

		int[][] output = { { 1 }, { 1, 1 }, { 1, 2, 1 }, { 1, 3, 3, 1 }, { 1, 4, 6, 4, 1 } };

		List<List<Integer>> list = generate(numRows);
		System.out.println("list: " + list);
	}

	public static List<List<Integer>> generate(int numRows) {

		List<List<Integer>> dp = new ArrayList<>();

		for (int i = 0; i < numRows; i++) {
			List<Integer> row = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				// first and last elements of the row are always 1
				if (j == 0 || j == i) {
					row.add(1);
				} else {
					int left = dp.get(i - 1).get(j - 1);
					int right = dp.get(i - 1).get(j);
					row.add(left + right);
				}
			}
			dp.add(row);
		}
		return dp;

	}

	public static List<List<Integer>> generateNormal(int numRows) {

		List<List<Integer>> triangle = new ArrayList<>();

		for (int i = 0; i < numRows; i++) {
			List<Integer> row = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				// first and last elements of the row are always 1
				if (j == 0 || j == i) {
					row.add(1);
				} else {
					int val = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
					row.add(val);
				}
			}
			triangle.add(row);
		}
		return triangle;

	}

}
