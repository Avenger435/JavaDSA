package com.java.dsa;

public class IntegerToRoman {

	public static void main(String[] args) {
		System.out.println(intToRoman(962));
	}

	public static String intToRoman(int num) {
		int[] storeInt = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 4, 5, 1 };
		String[] storeRoman = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

		StringBuilder romanNumeral = new StringBuilder();
		for (int i = 0; i < storeInt.length; i++) {
			while (num >= storeInt[i]) {
				romanNumeral.append(storeRoman[i]);
				num -= storeInt[i];
			}
		}
		return romanNumeral.toString();
	}
}
