package com.java.dsa;

public class SumOfTwoIntegers {

	public static void main(String[] args) {
		System.out.println(getSum(1, 2));
	}

	public static int getSum(int a, int b) {
		while (b != 0) {
			int carry = (a & b) << 1; // Calculate carry
			a = a ^ b; // Sum without carry
			b = carry; // Move carry to the next step
		}
		return a;
	}
}