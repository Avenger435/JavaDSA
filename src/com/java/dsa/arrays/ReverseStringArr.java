/**
 * 
 */
package com.java.dsa.arrays;

import java.util.Arrays;

/**
 * 
 */
public class ReverseStringArr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		char[] input = { 'h', 'e', 'l', 'l', 'o' };

		reverseString(input);
		System.out.println(Arrays.toString(input));
	}

	public static void reverseString(char[] s) {

		int start = 0;
		int end = s.length - 1;
		while (start < end) {
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			start++;
			end--;

		}

	}

}
