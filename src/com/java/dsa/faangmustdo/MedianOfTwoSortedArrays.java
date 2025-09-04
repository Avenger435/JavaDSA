package com.java.dsa.faangmustdo;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {

		int[] nums1 = { 1, 3, 5 };
		int[] nums2 = { 2, 4 };
		System.out.println(findMedianSortedArrays(nums1, nums2));

	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int[] merge = merge(nums1, nums2, nums1.length, nums2.length);

		if (merge.length % 2 == 1) {
			return merge[(merge.length - 1) / 2];
		} else {
			return ((double) merge[merge.length / 2 - 1] + (double) merge[merge.length / 2]) / 2.0;
		}
	}

	/**
	 * Merges two sorted arrays into a single sorted array.
	 *
	 * @param arr1 the first sorted array
	 * @param arr2 the second sorted array
	 * @param n    the length of the first array
	 * @param m    the length of the second array
	 * 
	 */
	private static int[] merge(int[] arr1, int[] arr2, int length1, int length2) {
		int[] result = new int[length1 + length2];
		int i = 0; // traverse arr1
		int j = 0; // traverse arr2
		int k = 0; // traverse result

		while (i < length1 && j < length2) { // boundary conditions
			if (arr1[i] < arr2[j]) { // if arr1 element at i is less than arr2 element at j
				result[k] = arr1[i]; // storing arr1 element into result
				i++;
			} else {
				result[k] = arr2[j]; // storing arr2 element into result
				j++;
			}
			k++;
		}
		// either arr1 got exhausted or arr2 got exhausted
		while (i < length1) { // arr2 got exhausted
			result[k] = arr1[i]; // storing arr1 element into result
			i++;
			k++;
		}

		while (j < length2) { // arr1 got exhausted
			result[k] = arr2[j]; // storing arr2 element into result
			j++;
			k++;
		}

		return result;

	}

}
