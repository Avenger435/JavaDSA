package com.java.dsa;

import java.util.ArrayList;
import java.util.List;

public class FindEvenNumbers {

	public static void main(String[] args) {

		// InputArr
		int[] arr1 = { 12, 345, 2, 6, 7896 };
		int[] arr2 = { 555, 901, 482, 1771 };
		System.out.println(findNumbers(arr1));
		System.out.println(findNumbers(arr2));
	}

	public static int findNumbers(int[] nums) {
		if (nums.length == 0) {
			return 0;
		} else {
			int ans = 0;
			for (int num : nums) {
				int counter = 0;
				while (num != 0) {
					num /= 10;
					counter++;
				}
				if (counter % 2 == 0) {
					ans++;
				}
			}
			return ans;
		}

	}

	public static int findNumbers1(int[] nums) {
		if (nums.length == 0) {
			return 0;
		} else {
			int counter = 0;
			for (int num : nums) {
				String valueOf = String.valueOf(num);
				System.out.println(valueOf);
				if (valueOf.length() % 2 == 0) {
					counter++;
				}
			}
			return counter;
		}

	}

}
