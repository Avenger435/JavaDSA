
package com.java.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervalsArrays {

	public static void main(String[] args) {

		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

		int[][] merge = merge(intervals);

		System.out.println(Arrays.deepToString(merge));

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

}
