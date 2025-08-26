package com.java.dsa.arrays;

import java.util.Arrays;

public class ArrayBasics {

	public static void main(String args[]) {

		int[] arr = { 1, 2, 3, 4, 5 };

		// traversal
		for (int i : arr) {
			System.out.print(i + " ");
		}

		int val = 3;
		int i = 3;
		insert(arr, arr.length, i, val);
		System.out.println(Arrays.toString(arr));

	}

	/**
	 * Inserts a value into the array at the specified index.
	 * 
	 * @param arr   The array (fixed-size).
	 * @param n     The current logical size (number of used slots).
	 * @param index The position to insert at.
	 * @param value The value to insert.
	 * @return The new logical size after insertion.
	 */
	public static int insert(int[] arr, int n, int index, int value) {
		if (n >= arr.length) {
			System.out.println("Insertion failed: array is full.");
			return n;
		}
		if (index < 0 || index > n) {
			System.out.println("Insertion failed: invalid index.");
			return n;
		}

		// Shift right
		for (int i = n - 1; i >= index; i--) {
			arr[i + 1] = arr[i];
		}

		// Insert new value
		arr[index] = value;
		return n + 1;
	}

}
