package com.java.dsa.blind75;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoomsTwo {

	public static void main(String args[]) {

		int[][] case1 = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		System.out.println("Case1: " + minMeetingRooms(case1));
	}

	public static int minMeetingRooms(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
		Queue<Integer> minHeap = new PriorityQueue<>();

		for (int[] interval : intervals) {
			if (!minHeap.isEmpty() && interval[0] >= minHeap.peek())
				minHeap.poll();
			minHeap.offer(interval[1]);
		}

		return minHeap.size();
	}

	public static int minMeetingRooms2(int[][] intervals) {
		final int n = intervals.length;
		int ans = 0;

		int[] starts = new int[n];
		int[] ends = new int[n];

		for (int i = 0; i < n; i++) {
			starts[i] = intervals[i][0];
			ends[i] = intervals[i][1];
		}

		Arrays.sort(starts);
		Arrays.sort(ends);

		for (int i = 0, j = 0; i < n; ++i) {
			if (starts[i] < ends[j]) {
				++ans;
			} else {
				++j;
			}
		}

		return ans;

	}
}
