package com.java.dsa;

public class ReverseBits {

	public static void main(String[] args) {

		int n = 43261596;
		int reverse = reverse(n);
		System.out.println("reverse: "+reverse);
	}

	private static int reverse(int n) {
	    // Initialize result to 0. This will store the reversed bits.
	    int result = 0;
	    // Loop through all 32 bits of the integer
	    for (int i = 0; i < 32; i++) {
	        // Shift result left by 1 to make space for the next bit
	        result <<= 1;
	        // Add the least significant bit of n to result
	        result |= (n & 1);
	        // Shift n right by 1 to process the next bit in the next iteration
	        n >>= 1;
	    }
	    // Return the reversed bits as an integer
	    return result;

	}

}