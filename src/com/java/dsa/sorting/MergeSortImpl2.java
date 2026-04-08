package com.java.dsa.sorting;

public class MergeSortImpl2 {

	public static void main(String[] args) {

		int[] arr = { 66, 22, 33, 11, 76 };
		System.out.println("Given Array is");
		printArr(arr);
		mergeSort(arr, 0, arr.length - 1);
		System.out.println("the sorted Array is ");
		printArr(arr);
	}

	private static void printArr(int[] arr) {

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

	private static void merge(int[] arr, int left, int mid, int right) {

		int n1 = mid - left + 1;
		int n2 = right - mid;

		int[] lArr = new int[n1];
		int[] rArr = new int[n2];

		for (int i = 0; i < n1; i++) {
			lArr[i] = arr[left + i];
		}
		for (int j = 0; j < n2; j++) {
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
