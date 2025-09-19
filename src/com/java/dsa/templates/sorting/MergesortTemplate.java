package com.java.dsa.templates.sorting;

import java.util.Arrays;
import java.util.List;

public class MergesortTemplate {

	public static void main(String[] args) {
		List<Integer> numList = Arrays.asList(7, 2, 5, 3);
		int[] nums = numList.stream().mapToInt(Integer::intValue).toArray();

		mergeSort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}

	private static void mergeSort(int[] nums, int lo, int hi) {
		if (lo == hi)
			return;

		int mid = (lo + (hi - lo)) / 2;

		mergeSort(nums, lo, mid);

		mergeSort(nums, mid + 1, hi);

		merge(nums, lo, mid, hi);
	}

	private static void merge(int[] nums, int lo, int mid, int hi) {

	}

}
