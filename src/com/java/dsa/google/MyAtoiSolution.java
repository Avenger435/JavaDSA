package com.java.dsa.google;

public class MyAtoiSolution {

	public static void main(String[] args) {
		
		int myAtoi1 = myAtoi1("-42");
		System.out.println("myAtoi1: "+ myAtoi1);
	}

	public static int myAtoi1(String s) {
		int i = 0, sign = 1, result = 0;

		while (i < s.length() && s.charAt(i) == ' ') {
			i++;
		}
		// check for sign
		if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
			sign = (s.charAt(i) == '-') ? -1 : 1;
			i++;
		}
		while (i < s.length() && Character.isDigit(s.charAt(i))) {
			int digit = s.charAt(i) - '0';
			// check for overflow;
			if (result > (Integer.MAX_VALUE - digit) / 10) {
				return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			result = result * 10 + digit;
			i++;
		}
		return result * sign;

	}

	public int myAtoi(String s) {
		int i = 0, sign = 1, result = 0;
		// Discard whitespaces in the beginning
		while (i < s.length() && s.charAt(i) == ' ') {
			i++;
		}
		// Check for sign
		if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
			sign = (s.charAt(i) == '-') ? -1 : 1;
			i++;
		}
		// Convert number and avoid overflow
		while (i < s.length() && Character.isDigit(s.charAt(i))) {
			int digit = s.charAt(i) - '0';
			// Check for overflow
			if (result > (Integer.MAX_VALUE - digit) / 10) {
				return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			result = result * 10 + digit;
			i++;
		}
		return result * sign;
	}

}
