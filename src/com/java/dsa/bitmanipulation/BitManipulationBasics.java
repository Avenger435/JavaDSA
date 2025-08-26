/**
 * 
 */
package com.java.dsa.bitmanipulation;

/**
 * 
 */
public class BitManipulationBasics {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int val = 16;
		int setBits = countSetBits(val);
		System.out.println("Binary val: " + Integer.toBinaryString(val));
		int buildInBitCounter = Integer.bitCount(val);
		System.out.println("buildInBitCounter: " + buildInBitCounter);
		System.out.println("noOfBits: " + setBits);
		int setBitsOpt = countSetBitsOpt(val);
		System.out.println("setBitsOpt: " + setBitsOpt);
	}

	/**
	 * @param intVal
	 * @return
	 */
	private static int countSetBits(int intVal) {
		if (intVal <= 0)
			return 0;
		int setBits = 0;

		while (intVal > 0) {
			setBits += intVal & 1;
			intVal >>= 1;
		}

		return setBits;
	}

	// Brian Kernighan's algorithm
	private static int countSetBitsOpt(int intVal) {
		int setBits = 0;

		while (intVal > 0) {
			intVal &= (intVal - 1);
			setBits++;
		}

		return setBits;
	}

}
