package com.java.dsa.faangmustdo;

import java.util.Arrays;


public class NonOverlappingIntervals {

	public static void main(String[] args) {

//		Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
		int eraseOverlapIntervals1 = eraseOverlapIntervals(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } });
		System.out.println("case 1: " + eraseOverlapIntervals1);

		int eraseOverlapIntervals2 = eraseOverlapIntervals(new int[][] { { 1, 2 }, { 1, 2 }, { 1, 2 } });
		System.out.println("case 2: " + eraseOverlapIntervals2);

		int eraseOverlapIntervals3 = eraseOverlapIntervals(new int[][] { { 1, 2 }, { 2, 3 } });
		System.out.println("case 3: " + eraseOverlapIntervals3);

		int eraseOverlapIntervals4 = eraseOverlapIntervals(
				new int[][] { { 1, 100 }, { 11, 22 }, { 1, 11 }, { 2, 12 } });
		System.out.println("case 4: " + eraseOverlapIntervals4);

	}

	public static int eraseOverlapIntervals(int[][] intervals) {

		int res = 0;

		if (intervals.length == 0)
			return res;

		int n = intervals.length;

		Arrays.sort(intervals, (a, b) -> (b[0] - a[0]));

		System.out.println(Arrays.deepToString(intervals));

		int[] current = intervals[0];
		for (int index = 1; index < n; index++) {
			int currentMin = current[0];
			int currentMax = current[1];
			int windowMin = intervals[index][0];
			int windowMax = intervals[index][1];
			// check for overlaps; --> touching doesn't mean overlapping.
			if (windowMin < currentMax && windowMax > currentMin) {
//				System.out.println("we have overlap");
				res++;
			} else {
				current = intervals[index];
			}

		}

		return res;
	}
}
