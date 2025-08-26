package com.java.dsa.arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringNoDups {

	public static void main(String[] args) {

//		String input = "abcabcbb"; // 3
		String input = ""; // 3
		int lengthOfLongestSubstring = lengthOfLongestSubstring(input);
		System.out.println("lengthOfLongestSubstring: " + lengthOfLongestSubstring);
	}

	public static int lengthOfLongestSubstring(String s) {

		int left = 0, maxLength = 0;

		Set<Character> hasSeen = new HashSet<>();
		for (int right = 0; right < s.length(); right++) {
			while (hasSeen.contains(s.charAt(right))) {
				hasSeen.remove(s.charAt(left));
				left++;
			}
			hasSeen.add(s.charAt(right));
			maxLength = Math.max(maxLength, right - left + 1);
		}
		return maxLength;
	}

}
