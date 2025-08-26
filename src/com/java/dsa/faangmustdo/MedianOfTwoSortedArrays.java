package com.java.dsa.faangmustdo;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {

		int[] nums1 = { 1, 3, 5 };
		int[] nums2 = { 2, 4 };
		System.out.println(findMedianSortedArrays(nums1, nums2));

	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int[] merge = merge(nums1, nums2, nums1.length, nums2.length);

		if (merge.length - 1 % 2 == 1) {
			return merge[merge.length / 2];
		} else {
			int sum = merge[merge.length / 2] + merge[merge.length + 1 / 2];
			return sum / 2;
		}

	}

	/**
	 * @param nums1
	 * @param nums2
	 * @param length
	 * @param length2
	 * @return
	 */
	private static int[] merge(int[] arr1, int[] arr2, int n, int m) {
		int[] result = new int[n + m];
		int i = 0; // traverse arr1
		int j = 0; // traverse arr2
		int k = 0; // traverse result

		while (i < n && j < m) { // boundary conditions
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
		while (i < n) { // arr2 got exhausted
			result[k] = arr1[i]; // storing arr1 element into result
			i++;
			k++;
		}

		while (j < m) { // arr1 got exhausted
			result[k] = arr2[j]; // storing arr2 element into result
			j++;
			k++;
		}

		return result;

	}

}
