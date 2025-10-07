package com.java.dsa.faangmustdo;

import java.util.Arrays;

public class MatrixSetZero {

	public static void main(String[] args) {

		int[][] case1 = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		System.out.println("case1: " + Arrays.deepToString(case1));

//		setZeros(case1);
		setZerosOpt(case1);
		System.out.println(Arrays.deepToString(case1));
	}

	public static void setZeros(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		boolean[] zeroRows = new boolean[m];
		boolean[] zeroCols = new boolean[n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					zeroRows[i] = true;
					zeroCols[j] = true;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (zeroRows[i] || zeroCols[j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	public static void setZerosOpt(int[][] matrix) {
		final int m = matrix.length;
		final int n = matrix[0].length;

		// Flags to check if first row or first column need to be zeroed
		boolean shouldFillFirstRow = false;
		boolean shouldFillFirstCol = false;

		// Check if any cell in the first row is zero
		for (int j = 0; j < n; ++j) {
			if (matrix[0][j] == 0) {
				shouldFillFirstRow = true;
				break;
			}
		}

		// Check if any cell in the first column is zero
		for (int i = 0; i < m; ++i) {
			if (matrix[i][0] == 0) {
				shouldFillFirstCol = true;
				break;
			}
		}

		// Use first row and first column as markers for zeroing
		for (int i = 1; i < m; ++i) {
			for (int j = 1; j < n; ++j) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0; // Mark row
					matrix[0][j] = 0; // Mark column
				}
			}
		}

		// Zero cells based on markers in first row and column
		for (int i = 1; i < m; ++i) {
			for (int j = 1; j < n; ++j) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		// Zero the first row if needed
		if (shouldFillFirstRow)
			for (int j = 0; j < n; ++j)
				matrix[0][j] = 0;

		// Zero the first column if needed
		if (shouldFillFirstCol)
			for (int i = 0; i < m; i++)
				matrix[i][0] = 0;
	}
}