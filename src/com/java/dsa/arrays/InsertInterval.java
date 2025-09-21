package com.java.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

	public static void main(String[] args) {

		int[][] intervals = { { 1, 3 }, { 6, 9 } };
		int[] newInterval = { 0, 10 };

		int[][] insert = insert(intervals, newInterval);

		System.out.println(Arrays.deepToString(insert));

	}

	public static int[][] insert(int[][] intervals, int[] newInterval) {

		List<int[]> result = new ArrayList<>();
		int i = 0;
		int n = intervals.length;

		while (i < n && intervals[i][1] < newInterval[0]) {
			result.add(intervals[i++]);
		}

		while (i < n && intervals[i][0] <= newInterval[1]) {
			newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
			newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
			i++;
		}
		result.add(newInterval);

		while (i < n) {
			result.add(intervals[i++]);
		}

		return result.toArray(new int[result.size()][]);
	}

}
