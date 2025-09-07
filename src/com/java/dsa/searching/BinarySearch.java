package com.java.dsa.searching;

public class BinarySearch {

	public static void main(String[] args) {

		int[] arr = { -1, 0, 3, 5, 9, 12 };
		int target = 9;

		int result = binarySearch(arr, target);
		System.out.println(result);

	}

	private static int binarySearch(int[] arr, int target) {
		// TODO Auto-generated method stub
		int lo = 0;
		int hi = arr.length - 1;

		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (target < arr[mid]) {
				hi = mid - 1;
			} else if (target > arr[mid]) {
				lo = mid + 1;
			} else
				return mid;
		}

		return -1;
	}

}
