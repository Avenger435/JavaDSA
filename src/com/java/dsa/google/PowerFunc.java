package com.java.dsa.google;

public class PowerFunc {

	public static void main(String[] args) {

		System.out.println("Case1: " + myPow(2, 10));
	}

	public static double myPow(double x, int n) {
		long num = Math.abs((long) n);
		double result = 1.0;
		while (num != 0) {
			if (num % 2 == 1) {
				result *= x;
				num -= 1;
			}
			x *= x;
			num = num / 2;
		}
		return n < 0 ? 1.0 / result : result;
	}

}
