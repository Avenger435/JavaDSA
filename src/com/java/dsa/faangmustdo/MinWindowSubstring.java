package com.java.dsa.faangmustdo;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

	public static void main(String[] args) {

		String minWindow = minWindow("ADOBECODEBANC", "ABC");
		System.out.println("minWindow: " + minWindow);

	}

	public static String minWindow(String s, String t) {
		// Maps to store required character counts and current window counts
		Map<Character, Integer> need = new HashMap<>();
		Map<Character, Integer> window = new HashMap<>();

		// Populate the need map with character frequencies from t
		for (char c : t.toCharArray())
			need.put(c, need.getOrDefault(c, 0) + 1);

		int left = 0, right = 0; // Window pointers
		int valid = 0; // Number of characters that meet the required count
		int start = 0, len = Integer.MAX_VALUE; // Track the start and length of the minimum window

		// Expand the window by moving right pointer
		while (right < s.length()) {
			char c = s.charAt(right);
			right++;

			// If the character is needed, update window count
			if (need.containsKey(c)) {
				window.put(c, window.getOrDefault(c, 0) + 1);
				// If window count matches need count, increment valid
				if (window.get(c).equals(need.get(c)))
					valid++;
			}
			// When all required characters are satisfied, try to shrink the window
			while (valid == need.size()) {
				// Update minimum window if current window is smaller
				if (right - left < len) {
					start = left;
					len = right - left;
				}
				char d = s.charAt(left);
				left++;
				// If the character is needed, update window count and valid
				if (need.containsKey(d)) {
					if (window.get(d).equals(need.get(d)))
						valid--;
					window.put(d, window.get(d) - 1);
				}
			}
		}

		// Return the minimum window substring if found, else empty string
		return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
	}
}