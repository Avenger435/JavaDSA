package com.java.dsa.google.leetcollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class PatternMatchers {

	public static void main(String[] args) {
		String pattern = "tele[op]ho[bnm]e";
		List<String> list = Arrays.asList("cat", "dog", "telephone", "telephonepole", "tele", "telehoe",
				"teleophobnme");
		List<String> result = Arrays.asList("telephone");
		
		
		List<String> matchPatternList = matchPattern(pattern,list);
		
		System.out.println(matchPatternList);
		
		System.out.println("Case 1: "+ matchPatternList.equals(result));

	}

	public static String expandPatter(String pattern) {
		StringBuilder regex = new StringBuilder("^"); // match from start.
		int i = 0;

		while (i < pattern.length()) {
			char c = pattern.charAt(i);

			if (c == '[') {
				i++;
				StringBuilder group = new StringBuilder();
				while (i < pattern.length() && pattern.charAt(i) != ']') {
					group.append(pattern.charAt(i)).append("|");
					i++;
				}
				if (group.length() > 0)
					group.setLength(group.length() - 1);
				regex.append("(").append(group).append(")");

			} else {
				regex.append(Pattern.quote(String.valueOf(c))); // escape literal
			}
			i++;

		}
		regex.append("$");

		return regex.toString();
	}

	public static List<String> matchPattern(String pattern, List<String> candidates) {

		String regex = expandPatter(pattern);
		Pattern compiled = Pattern.compile(regex);
		System.out.println(compiled.toString());
		List<String> result = new ArrayList<>();

		for (String s : candidates) {
			if (compiled.matcher(s).matches()) {
				result.add(s);
			}
		}
		return result;
	}

}
