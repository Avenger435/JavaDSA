/**
 * 
 */
package com.java.dsa.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 */
public class ToeplitzMatrix {
	public static void main(String[] args) {
		int[][] case1 = { { 1, 2, 3, 4 }, { 5, 1, 2, 3 }, { 9, 5, 1, 2 } };
		System.out.println(Arrays.deepToString(case1));
		System.out.println("Case 1: " + (isToeplitzMatrix(case1) == true));
		int[][] case2 = { { 1, 2 }, { 2, 2 } };
		System.out.println(Arrays.deepToString(case2));
		System.out.println("Case 2: " + (isToeplitzMatrix(case2) == false));
	}

	public static boolean isToeplitzMatrix(int[][] matrix) {
		int rows = matrix.length, cols = matrix[0].length;

		// from top row
		for (int col = 0; col < cols; col++) {
			int val = matrix[0][col];
			int i = 0;
			int j = col;
			while (i < rows && j < cols) {
				if (matrix[i][j] != val)
					return false;
				i++;
				j++;
			}
		}

		// from left column (excluding [0][0] diagonal again)
		for (int row = 1; row < rows; row++) {
			int val = matrix[row][0];
			int i = row;
			int j = 0;
			while (i < rows && j < cols) {
				if (matrix[i][j] != val)
					return false;
				i++;
				j++;
			}
		}
		return true;
	}

}
