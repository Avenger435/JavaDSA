package com.java.dsa;

public class LongestSubstringCharacterReplacement {

	public static void main(String[] args) {

		String s = "AABABCC";
		int k = 2;
		System.out.println(characterReplacement(s, k));

	}

	public static int characterReplacement(String s, int k) {

		int[] freq = new int[26];
		int left = 0;
		int maxFreq = 0;
		int maxWindow = 0;

		for (int right = 0; right < s.length(); right++) {

			//update the frequency of the current character
			freq[s.charAt(right) - 'A']++;

			//update the max Frequency
			maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

			int windowLength = right - left + 1;
			//if window length -max frequency >k,
			//then we need to shrink the window
			if (windowLength - maxFreq > k) {
				freq[s.charAt(left) - 'A']--;
				left++;
			}

			windowLength = right - left + 1;
			maxWindow = Math.max(maxWindow, windowLength);
		}
		return maxWindow;
	}
}
