package com.java.dsa;

public class PalindromeNumber {

	public static void main(String[] args) {
		
		System.out.println("case 1: "+ isPalindromeNum(0));
		System.out.println("case 2: "+ isPalindromeNum(121));
		System.out.println("case 3: "+ isPalindromeNum(-121));
		System.out.println("case 4: "+ isPalindromeNum(10));
		System.out.println("case 5: "+ isPalindromeNum(-101));
		System.out.println("case 6: "+ isPalindromeNum(12321));
		System.out.println("case 7: "+ isPalindromeNum(123321));
	}

	public static boolean isPalindromeNum(int x) {
		if (x < 0)
			return false;
		if (x != 0 && x % 10 == 0)
			return false;

		int reverse = 0;
		while (x > reverse) {
			int lastDigit = x % 10;
			reverse = reverse * 10 + lastDigit;
			x /= 10;
		}

		return (x == reverse) || (x == reverse / 10);
	}
}
