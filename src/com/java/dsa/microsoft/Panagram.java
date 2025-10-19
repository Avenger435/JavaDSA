package com.java.dsa.microsoft;

public class Panagram {
	public static void main(String args[]) {

		System.out.println("Case 1: " + checkIfPangram("leetcode"));
		System.out.println("Case 2: " + checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
	}

	public static boolean checkIfPangram(String sentence) {

		int[] count = new int[26];

		for (int i = 0; i < sentence.length(); i++) {
			count[sentence.charAt(i) - 'a']++;
		}
		for (int num : count) {
			if (num == 0)
				return false;
		}

		return true;
	}
}
