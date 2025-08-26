/**
 * 
 */
package com.java.dsa.util;

/**
 * 
 */
public class PowerOfThreeBenchmark {

	// Method 1: Iterative Division
	public static boolean isPowerOfThreeDiv(int n) {
		if (n < 1)
			return false;
		while (n % 3 == 0) {
			n /= 3;
		}
		return n == 1;
	}

	// Method 2: Math Divisibility Shortcut (max 3^19)
	public static boolean isPowerOfThreeFast(int n) {
		return n > 0 && 1162261467 % n == 0;
	}

	// Method 3: Logarithmic Check
	public static boolean isPowerOfThreeLog(int n) {
		if (n <= 0)
			return false;
		double logBase3 = Math.log10(n) / Math.log10(3);
		return Math.abs(logBase3 - Math.round(logBase3)) < 1e-10;
	}

	// Benchmark Runner
	public static void benchmark(int n) {
		long start, end;

		start = System.nanoTime();
		boolean result1 = isPowerOfThreeDiv(n);
		end = System.nanoTime();
		System.out.println("Iterative → Result: " + result1 + " | Time: " + (end - start) + " ns");

		start = System.nanoTime();
		boolean result2 = isPowerOfThreeFast(n);
		end = System.nanoTime();
		System.out.println("Divisibility Trick → Result: " + result2 + " | Time: " + (end - start) + " ns");

		start = System.nanoTime();
		boolean result3 = isPowerOfThreeLog(n);
		end = System.nanoTime();
		System.out.println("Logarithmic → Result: " + result3 + " | Time: " + (end - start) + " ns");
	}

	public static void main(String[] args) {
		int[] testValues = { 3, 9, 27, 243, 2187, 10000, Integer.MAX_VALUE };

		for (int val : testValues) {
			System.out.println("Checking n = " + val);
			benchmark(val);
			System.out.println();
		}
	}
}