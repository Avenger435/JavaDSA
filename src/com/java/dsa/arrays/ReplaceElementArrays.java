/**
 * 
 */
package com.java.dsa.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/description/
 */
public class ReplaceElementArrays {

	public static void main(String[] args) {

		int[] arr = { 17, 18, 5, 4, 6, 1 };
		int[] replaceElement = replaceElement(arr);
		System.out.println(Arrays.toString(replaceElement));
	}

	public static int[] replaceElement(int[] arr) {

		int maxSoFar = -1;
		for (int index = arr.length - 1; index >= 0; index--) {
			// save the arr[index] into the temp value for comparision
			int temp = arr[index];
			// update arr[index] with maxSoFar
			arr[index] = maxSoFar;
			// update max comparing with current element.
			maxSoFar = Math.max(maxSoFar, temp);
		}
		return arr;
	}

}
