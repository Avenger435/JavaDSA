package com.java.dsa;

public class LongestCommonPrefix {

	public static void main(String[] args) {

		String[] strs= {"flower","flow","float"};
		String pref= longestCommonPrefix(strs);
		System.out.println("prefix: "+ pref);
	}

	public static String longestCommonPrefix(String[] strs) {

		if (strs.length == 0)
			return "";

		String prefix = strs[0];

		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty())
					return "";
			}
		}
		return prefix;
	}
}
