package com.java.dsa;

public class TrailingZerosFact {

	public static void main(String[] args) {

		System.out.println(trailingZeros(5));
		System.out.println(trailZero(5));

	}

	public static int trailingZeros(int n) {
		int count = 0;
		while (n > 0) {
			n /= 5;
			count += n;
		}
		return count;
	}

	public static int trailZero(int n) {
		int count = 0;
		int currentFivePower = 5;
		while (n >= currentFivePower) {
			count += n/currentFivePower;
			currentFivePower*=5;
		}
		return count;
	}
}
