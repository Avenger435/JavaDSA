/**
 * 
 */
package com.java.dsa.googletop50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 */
public class InsertIntervalArray {

	public static void main(String[] args) {

		int[][] arr = { { 1, 3 }, { 6, 9 } };
		System.out.println(Arrays.deepToString(arr));

		int[] newInterval = { 0, 10 };
		System.out.println(Arrays.toString(newInterval));
		int[][] res = insertInterval(arr, newInterval);
		System.out.println("res: " + Arrays.deepToString(res));
	}

	private static int[][] insertInterval(int[][] intervals, int[] newInterval) {
		List<int[]> result = new ArrayList<>();

		if (intervals.length != 0 && newInterval.length == 0)
			return intervals;

		if (intervals.length == 0 && newInterval.length != 0) {
			result.add(newInterval);
			return result.toArray(new int[1][]);
		}

		int i = 0;
		int n = intervals.length;

		while (i < n && intervals[i][1] < newInterval[0]) {
			result.add(intervals[i]);
			i++;
		}

		result.forEach(arr-> System.out.println(Arrays.toString(arr)));

		while (i < n && intervals[i][0] <= newInterval[1]) {
			newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
			newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
			i++;
		}
		result.add(newInterval);

		result.forEach(arr-> System.out.println(Arrays.toString(arr)));

		
		
		while (i < n) {
			result.add(intervals[i]);
			i++;
		}

		result.forEach(arr-> System.out.println(Arrays.toString(arr)));

		
		return result.toArray(new int[result.size()][]);
	}

	public static int[][] merge(int[][] intervals) {

		// create a result array
		List<int[]> merged = new ArrayList<>();
		// Input validation, edge case, simply return the input
		if (intervals.length == 0)
			return intervals;

		// Sorting as we do not know if the array is sorted,
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		// take the first interval as current to compare
		int[] current = intervals[0]; // holds first set // current[0]=1, current[1]=3

		// loop through the array. start at index 1 as we took current as 0th position.
		for (int i = 1; i < intervals.length; i++) {
			// compare the second element in the set with next value that is first element
			// of the next set
			if (current[1] >= intervals[i][0]) {
				// check if current set second value is greater or next set second value; and
				// assign the current set second value, this merging the 2 sets
				current[1] = Math.max(current[1], intervals[i][1]);
			} else {
				// else just add the current set to the mergedList as we do not see any overlaps
				merged.add(current);
				// move to the next
				current = intervals[i];
			}
		}

		// add the current as in the merge condition we merged.
		merged.add(current);

		// return the values
		return merged.toArray(new int[merged.size()][]);
	}

	/**
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
	private static int[][] insertInterval1(int[][] intervals, int[] newInterval) {

		if (intervals.length == 0)
			return intervals;

		List<int[]> merged = new ArrayList<>();
		for (int index = 0; index < intervals.length; index++) {
			System.out.println("current" + Arrays.toString(intervals[index]));
			if (newInterval[0] <= intervals[index][0] && newInterval[1] >= intervals[index][1]) {
				intervals[index][0] = Math.min(newInterval[0], intervals[index][0]);
				intervals[index][1] = Math.max(newInterval[1], intervals[index][1]);
				index++;
			} else {
				System.out.println("here");
			}

		}
		System.out.println(Arrays.deepToString(intervals));
		return intervals;
	}

}
