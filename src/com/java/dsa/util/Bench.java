/**
 * 
 */
package com.java.dsa.util;

/**
 * 
 */
public class Bench {
	public static void main(String[] args) {
		int val=15;
		benchmark(val);
	}

	public static void benchmark(int val) {
		long start, end;

		// Standard Method
		start = System.nanoTime();
		int count1 = 0, x1 = val;
		while (x1 > 0) {
			count1 += x1 & 1;
			x1 >>= 1;
		}
		end = System.nanoTime();
		System.out.println("Standard Count: " + count1 + " | Time: " + (end - start) + " ns");

		// Kernighan's Method
		start = System.nanoTime();
		int count2 = 0, x2 = val;
		while (x2 > 0) {
			x2 &= (x2 - 1);
			count2++;
		}
		end = System.nanoTime();
		System.out.println("Kernighan Count: " + count2 + " | Time: " + (end - start) + " ns");
	}

}
