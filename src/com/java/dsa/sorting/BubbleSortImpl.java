/**
 * 
 */
package com.java.dsa.sorting;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Bubble Sort's time complexity is O(n^2) in the average and worst-case
 * scenarios, where 'n' is the number of elements in the array. This means the
 * time it takes to sort increases quadratically with the size of the input. In
 * the best-case scenario, when the array is already sorted, it has a time
 * complexity of O(n).
 *
 * 
 * Big O Notation Breakdown:
 * 
 * Time complexity
 * 
 * O(n^2) (Average and Worst Case):
 * 
 * The algorithm has nested loops. The outer loop iterates through the array 'n'
 * times. The inner loop, in the worst and average cases, also iterates through
 * the array 'n' times for each iteration of the outer loop.
 *
 * Therefore, the total number of comparisons and swaps (and thus the time
 * complexity) grows proportionally to n * n, which is represented as O(n^2).
 * 
 * O(n) (Best Case):
 * 
 * If the array is already sorted, the algorithm will only need to iterate
 * through the array once to confirm that no swaps are needed.
 *
 * 
 * In this case, the number of operations is directly proportional to the size
 * of the input, resulting in O(n) time complexity.
 * 
 * Space complexity
 * 
 * Space complexity is O(1): It sorts the array in-place, meaning it doesn't
 * require extra memory proportional to the input size.
 * 
 */
public class BubbleSortImpl {

	/**
	 * Demonstrates how to use the bubbleSort method with an example array.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Hello from Bubble sort");

		int len = 20;
		int[] arr = new int[20];
		int min = 0;
		int max = 1000;
		for (int i = 0; i < len; i++) {
			arr[i] = ThreadLocalRandom.current().nextInt(min, max + 1);
		}

		System.out.println("Unsorted Array: " + Arrays.toString(arr));

		bubbleSort(arr);
		System.out.println("Sorted Array: " + Arrays.toString(arr));

	}

	public static void bubbleSort(int[] arr) {
		/**
		 * length of the Arrays.
		 */
		int n = arr.length;
		/**
		 * swapped is a boolean flag used for optimization. If no swaps occur during an
		 * entire pass through the inner loop, it means the array is already sorted, and
		 * the algorithm can terminate early.
		 * 
		 */
		boolean swapped;

		/**
		 * Outer loop (for (int i = 0; i < n - 1; i++)): This loop controls the number
		 * of passes. In each pass, the largest unsorted element "bubbles up" to its
		 * correct position at the end of the unsorted portion of the array. The n - 1
		 * ensures that the loop runs n-1 times, which is sufficient to sort all
		 * elements.
		 * 
		 */
		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			/**
			 * Inner loop (for (int j = 0; j < n - 1 - i; j++)): This loop iterates through
			 * the unsorted portion of the array, comparing adjacent elements. The n - 1 - i
			 * in the condition is important because after each pass of the outer loop, the
			 * largest element is already in its correct position at the end, so we don't
			 * need to compare elements beyond that point.
			 * 
			 */
			for (int j = 0; j < n - 1 - i; j++) {

				/**
				 * Comparison and Swap: if (arr[j] > arr[j + 1]) checks if the current element
				 * is greater than the next element. If it is, they are swapped using a
				 * temporary variable temp. The swapped flag is set to true to indicate that a
				 * swap occurred.
				 * 
				 */
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j]; // take j index value into temp
					arr[j] = arr[j + 1]; // update j with value of j+1
					arr[j + 1] = temp; // now change value of j+1 to temp(which is j), so in place swap is done,
					swapped = true; // a swap occurred
				}
			}
			// if no two elements were swapped by inner loop, then break
			/**
			 * Optimization (if (!swapped) { break; }): After each pass of the inner loop,
			 * if swapped remains false, it means no elements were swapped in that entire
			 * pass, indicating the array is already sorted, and the outer loop can be
			 * terminated.
			 * 
			 */
			if (!swapped)
				break;
		}

	}

}
