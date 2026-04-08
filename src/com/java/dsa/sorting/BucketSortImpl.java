package com.java.dsa.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSortImpl {

	public static void main(String[] args) {
		float[] arr = { 1000, 200, 862, 77, 565, 221 };
		bucketSort(arr);
		System.out.println("Sorted Array is: ");
		for(float num: arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	public static void bucketSort(float[] arr) {
		int n = arr.length;
		if (n == 0) return;
		float min_val = Float.MAX_VALUE;
		float max_val = Float.MIN_VALUE;
		for (float num : arr) {
			if (num < min_val) min_val = num;
			if (num > max_val) max_val = num;
		}

		int bucketCount = (int) Math.sqrt(n) + 1;

		// create empty buckets
		List<Float>[] buckets = new ArrayList[bucketCount];
		for (int i = 0; i < bucketCount; i++) {
			buckets[i] = new ArrayList<Float>();
		}

		// insert into their respective buckets
		for (int i = 0; i < n; i++) {
			int index = (int) ((arr[i] - min_val) * bucketCount / (max_val - min_val + 1));
			buckets[index].add(arr[i]);
		}

		for (int i = 0; i < bucketCount; i++)
			Collections.sort(buckets[i]);
		int index = 0;
		for (int i = 0; i < bucketCount; i++) {
			for (float num : buckets[i]) {
				arr[index++] = num;
			}
		}
	}

}