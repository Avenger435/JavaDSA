package com.java.dsa;

public class ReverseInt {

	public static void main(String[] args) {
	
		int reverse = reverse(1234567898);
		System.out.println(reverse);
		System.out.println(reverse(121));

		System.out.println(reverse(-121));
	}

	public static int reverse(int n) {
		int reverse = 0;
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		while (n!= 0) {
			int lastDigit = n % 10;
			if (reverse > max / 10 || reverse < min / 10)
				return 0;
			reverse = reverse * 10 + lastDigit;
			n /= 10;
		}
		return reverse;
	}
}
