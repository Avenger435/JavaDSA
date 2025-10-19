package com.java.dsa.google;

public class NUniqueZero {

	public static void main(String[] args) {
		sumZero(5);
	}

	public static int[] sumZero(int n) {
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = i * 2 - n + 1;
		}
		return result;
	}

}
