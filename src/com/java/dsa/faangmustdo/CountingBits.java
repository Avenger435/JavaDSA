package com.java.dsa.faangmustdo;

import java.util.Arrays;

public class CountingBits {

	public static void main(String[] args) {

		System.out.println("count1: " + Arrays.toString(countBits(2)));

	}

	public static int[] countBits(int n) {
		int[] res = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			res[i] = res[i >> 1] + (i & 1);
		}
		return res;
	}

	public static int countOnes(int n) {
		int count = 0;
		while (n != 0) {
			n = n & (n - 1);
			count++;
		}
		return count;
	}

}
