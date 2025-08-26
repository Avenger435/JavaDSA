/**
 * 
 */
package com.java.dsa.google;

/**
 * 
 */
public class PowerTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isPowerOfTwo(int n) {
		if (n < 0)
			return false;
		int noOfSetBits = 0;
		while (n != 0) {
			n &= (n - 1);
			noOfSetBits++;
		}
		return noOfSetBits == 1;
	}

}
