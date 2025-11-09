package com.java.dsa.blind75;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {

	public static void main(String args[]) {
		int[][] intervals = { { 5, 10 }, { 11, 22 } };
		System.out.println("Case 1: " + canAttendMeetings(intervals));
	}

	public static boolean canAttendMeetings(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
		for (int i = 1; i < intervals.length; ++i) {
			if (intervals[i - 1][1] > intervals[i][0])
				return false;
		}
		return true;
	}

}
