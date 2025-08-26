/**
 * 
 */
package com.java.dsa.util;

/**
 * 
 */
public class PowerFour {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long start = System.nanoTime();
		System.out.println("isPowerFour: " + isPowerFour(64));
		long end = System.nanoTime();

		System.out.println("isPowerFour: " + " | Time: " + (end - start) + " ns");

		long start1 = System.nanoTime();
		System.out.println("is Power 4?: " + powerFourbitManipulation(16));
		long end1 = System.nanoTime();
		System.out.println("powerFourbitManipulation: " + " | Time: " + (end1 - start1) + " ns");
		long start2 = System.nanoTime();

		System.out.println("is Power 4?: " + powerFour(16));
		long end2 = System.nanoTime();
		System.out.println("powerFour: " + " | Time: " + (end2 - start2) + " ns");

		long start3 = System.nanoTime();

		System.out.println("is Power 4?: " + powerFourRec(16));
		long end3 = System.nanoTime();
		System.out.println("powerFourRec: " + " | Time: " + (end3 - start3) + " ns");

	}

	private static boolean powerFourRec(int n) {
		if (n == 1)
			return true;
		if (n % 4 != 0 && n <= 0)
			return false;

		return powerFourRec(n / 4);
	}

	/**
	 * @param powVal
	 */
	private static boolean isPowerFour(int powVal) {

		if (powVal < 0)
			return false;
		while (powVal % 4 == 0) {
			powVal /= 4;
		}

		return powVal == 1;
	}

	private static boolean powerFourbitManipulation(int n) {
		return n > 0 && (n & (n - 1)) == 0 && (n & 0xAAAAAAAA) == 0;
	}

	private static boolean powerFour(int n) {
		return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
	}
}
