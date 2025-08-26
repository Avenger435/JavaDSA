/**
 * 
 */
package com.java.dsa.util;

/**
 * 
 */
public class BitCountBenchmark {

	public static void main(String[] args) {
		int[] testValues = { 13, 1023, 1048575, Integer.MAX_VALUE }; // Small to massive

		for (int val : testValues) {
			System.out.println("Input: " + val);

			benchmarkStringMethod(val);
			benchmarkNaiveBitwise(val);
			benchmarkKernighan(val);

			System.out.println();
		}
	}

	static void benchmarkStringMethod(int val) {
		long start = System.nanoTime();

		String binary = Integer.toBinaryString(val);
		int count = 0;
		for (char c : binary.toCharArray()) {
			if (c == '1')
				count++;
		}

		long end = System.nanoTime();
		System.out.println("String Method -> Count: " + count + " | Time: " + (end - start) + " ns");
	}

	static void benchmarkNaiveBitwise(int val) {
		long start = System.nanoTime();

		int count = 0, x = val;
		while (x > 0) {
			count += x & 1;
			x >>= 1;
		}

		long end = System.nanoTime();
		System.out.println("Naive Bitwise -> Count: " + count + " | Time: " + (end - start) + " ns");
	}

	static void benchmarkKernighan(int val) {
		long start = System.nanoTime();

		int count = 0, x = val;
		while (x > 0) {
			x &= (x - 1);
			count++;
		}

		long end = System.nanoTime();
		System.out.println("Kernighan's -> Count: " + count + " | Time: " + (end - start) + " ns");
	}
}