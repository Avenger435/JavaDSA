package com.java.dsa.blind75;

public class ReverseInteger {

	public static void main(String[] args) {
		int x = 1000;
		int x1 = 231;
		System.out.println(reverse(x));
		System.out.println(reverse(x1));
		System.out.println(reverse(1534236469));
		System.out.println(Integer.MAX_VALUE);
	}

	private static int reverse(int x) {

		int reversed = 0;
		while (x != 0) {
			int digit = x % 10;
			if (reversed > Integer.MAX_VALUE / 10 || reversed < Integer.MIN_VALUE / 10) {
				return 0;
			}
			reversed = reversed * 10 + digit;
			x = x / 10;
		}
		return reversed;
	}
}
