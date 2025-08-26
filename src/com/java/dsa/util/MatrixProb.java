/**
 * 
 */
package com.java.dsa.util;

import java.util.Arrays;

/**
 * 
 */
public class MatrixProb {

	public static void main(String[] args) {
		int[][] case1 = { { 1, 2, 3, 4 }, { 5, 1, 2, 3 }, { 9, 5, 1, 2 } };
		System.out.println(Arrays.deepToString(case1));
		System.out.println("Case 1: " + (isToeplitzMatrix(case1) == true));
		int[][] case2 = { { 1, 2 }, { 2, 2 } };
		System.out.println(Arrays.deepToString(case2));
		System.out.println("Case 2: " + (isToeplitzMatrix(case2) == false));
	}

	public static boolean isToeplitzMatrix(int[][] matrix) {

		int rows = matrix.length;
		int columns = matrix[0].length;

		for (int col = 0; col < columns; col++) {

			int val = matrix[0][col];
			int i = 0;
			int j = col;
			while (i < rows && j < columns) {
				if (matrix[i][j] != val)
					return false;
				i++;
				j++;
			}
		}

		for (int row = 1; row < rows; row++) {
			int val = matrix[row][0];
			int i = row;
			int j = 0;
			while (i < rows && j < columns) {
				if (matrix[i][j] != val)
					return false;
				i++;
				j++;
			}
		}

		return true;
	}

}
