package com.java.dsa.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC30 {

	public static void main(String[] args) {

		// base edge case
		List<Integer> case1 = findSubstring(null, new String[] {});
		List<Integer> case2 = findSubstring("barfoothefoobarman", new String[] { "bar", "foo" });

		System.out.println("Case1: " + case1);
		System.out.println("Case2: " + case2);
	}

	public static List<Integer> findSubstring(String s, String[] words) {
		if (s == null || s.isEmpty() || words == null || words.length == 0)
			return new ArrayList<>();

		final int k = words.length;
		final int n = words[0].length();
		List<Integer> ans = new ArrayList<>();
		Map<String, Integer> count = new HashMap<>();

		for (final String word : words)
			count.merge(word, 1, Integer::sum);

		System.out.println("count: " + count);

		for (int i = 0; i <= s.length() - k * n; i++) {
			Map<String, Integer> seen = new HashMap<>();
			int j = 0;
			for (; j < k; ++j) {
				final String word = s.substring(i + j * n, i + j * n + n);
				seen.merge(word, 1, Integer::sum);
				if (seen.get(word) > count.getOrDefault(word, 0))
					break;
			}
			if (j == k)
				ans.add(i);
		}

		return ans;
	}

}
