package com.java.dsa.faangmustdo;

import java.util.Arrays;

public class MatrixSetZero {

	public static void main(String[] args) {

		int[][] case1 = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		System.out.println("case1: " + Arrays.deepToString(case1));

		setZeros(case1);
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
}
