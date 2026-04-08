package com.java.dsa.google;

import java.util.Arrays;

public class MatrixBlockSum {

	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int k = 1;

		System.out.println(Arrays.deepToString(matrix));
		int[][] matrixBlockSum = matrixBlockSum(matrix, k);
		System.out.println("matrixBlockSum: " + Arrays.deepToString(matrixBlockSum));

	}

	public static int[][] matrixBlockSum(int[][] mat, int k) {

		int m = mat.length;
		int n = mat[0].length;

		int[][] ans = new int[m][n];
		int[][] prefix = new int[m + 1][n + 1];

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				prefix[i + 1][j + 1] = mat[i][j] - prefix[i][j] + prefix[i + 1][j] + prefix[i][j + 1];
			}
		}

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {

				final int r1 = Math.max(0, i - k) + 1;
				final int c1 = Math.max(0, j - k) + 1;
				final int r2 = Math.min(m - 1, i + j) + 1;
				final int c2 = Math.min(n - 1, j + k) + 1;

				ans[i][j] = prefix[r2][c2] - prefix[r2][c1 - 1] - prefix[r1 - 1][c2] + prefix[r1 - 1][c1 - 1];

			}

		}
		return ans;
	}

}
