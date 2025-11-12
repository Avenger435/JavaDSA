package com.java.dsa.google;

import java.util.Arrays;

public class MatrixBlockSum {

	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int k = 1;

		System.out.println(Arrays.deepToString(matrix));
		int[][] matrixBlockSum = matrixBlockSum(matrix, k);
		System.out.println("matrixBlockSum: " + Arrays.toString(matrixBlockSum));

	}

	public static int[][] matrixBlockSum(int[][] mat, int k) {

		return new int[][] {};
	}

}
