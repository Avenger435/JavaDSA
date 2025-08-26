/**
 * 
 */
package com.java.dsa.util;

/**
 * 
 */
public class PowerThree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Integer.bitCount(9));
		System.out.println(3 * 3 * 3);
		System.out.println(isPowerOfThree(27));
		System.out.println("maxPowerOfThree: " + maxPowerOfThree(243));

	}

	public static boolean maxPowerOfThree(int n) {
		return n > 0 && 1162261467 % n == 0;
	}

	public static boolean isPowerOfThree(int n) {
		if (n < 1) {
			return false;
		}
		while (n % 3 == 0) {
			n /= 3;
		}
		return n == 1;
	}

}
