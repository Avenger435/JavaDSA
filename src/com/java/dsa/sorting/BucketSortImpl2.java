package com.java.dsa.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSortImpl2 {

	public static void main(String[] args) {
		
		float[] arr = { 0.78f,0.78f,0.78f,0.78f,0.78f,0.78f,0.78f,0.78f};

		System.out.println("Given array is:");
		printArray(arr);

		bucketSort(arr);

		System.out.println("\nSorted array is:");
		printArray(arr);
	}

	private static void printArray(float[] arr) {
		for(float num: arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	public static void bucketSort(float[] arr) {
		// Get the length of the input array
		int n = arr.length;

		// If the array is empty, return early
		if (n == 0)
			return;

		// Initialize minValue to the largest possible float
		float minValue = Float.MAX_VALUE;
		// Initialize maxValue to the smallest possible float
		float maxValue = Float.MIN_VALUE;

		// Loop through the array to find min and max values
		for (float num : arr) {
			// Update minValue if current number is smaller
			if (num < minValue)
				minValue = num;
			// Update maxValue if current number is larger
			if (num > maxValue)
				maxValue = num;
		}

		// Calculate bucket count using square root of n plus one for better distribution
		int bucketCount = (int) Math.sqrt(n) + 1;

		// Create an array of ArrayLists to hold the buckets
		List<Float>[] buckets = new ArrayList[bucketCount];
		// Initialize each bucket as an empty ArrayList
		for (int i = 0; i < bucketCount; i++) {
			buckets[i] = new ArrayList<Float>();
		}

		// Distribute elements into their respective buckets
		for (int i = 0; i < n; i++) {
			// Calculate the bucket index based on scaled value
			int index = (int) ((arr[i] - minValue) * bucketCount / (maxValue - minValue + 1));
			// Add the current element to the calculated bucket
			buckets[index].add(arr[i]);
		}

		// Sort each bucket individually
		for (int i = 0; i < bucketCount; i++) {
			Collections.sort(buckets[i]);
		}
		// Initialize index for merging back into original array
		int index = 0;
		// Merge sorted buckets back into the original array
		for (int i = 0; i < bucketCount; i++) {
			// Loop through each element in the current bucket
			for (float num : buckets[i]) {
				// Place the element back into the original array
				arr[index++] = num;
			}
		}

	}

}