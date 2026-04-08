package com.java.dsa.sorting;

public class MergeSortImpl {

	public static void main(String[] args) {

		int[] arr = { 38, 27, 43, 3, 9, 82, 10 };

		System.out.println("Given array is");
		printArray(arr);
		mergeSort(arr, 0, arr.length - 1);
		System.out.println("\nSorted array is");
		printArray(arr);

	}

	public static void printArray(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i] + " ");
		}
		System.out.println();
	}

	public static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	public static void merge(int[] arr, int left, int mid, int right) {

		int n1 = mid - left + 1;
		int n2 = right - mid;

		int lArr[] = new int[n1];
		int rArr[] = new int[n2];

		for (int i = 0; i < n1; ++i) {
			lArr[i] = arr[left + i];
		}
		for (int j = 0; j < n2; ++j) {
			rArr[j] = arr[mid + 1 + j];
		}

		int i = 0, j = 0;
		int k = left;

		while (i < n1 && j < n2) {
			if (lArr[i] <= rArr[j]) {
				arr[k] = lArr[i];
				i++;
			} else {
				arr[k] = rArr[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = lArr[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = rArr[j];
			j++;
			k++;
		}
	}
}
