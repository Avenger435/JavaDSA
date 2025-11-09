package com.java.dsa;

public class Pangram {

	public static void main(String[] args) {

		String sentence = "abcdefghijjklmnopqrstuvwxyz";

//		System.out.println("Case: " + checkIfPangram(sentence));
//		System.out.println("Case: " + checkIfPangram("leetcode"));

		System.out.println("Case: " + checkIfPanagramBitMask(sentence));
//		System.out.println("Case: " + checkIfPanagramBitMask("leetcode"));
		
	}

	public static boolean checkIfPangram(String sentence) {
		if (sentence == null || sentence.isEmpty())
			return false;

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

	public static boolean checkIfPanagramBitMask(String sentence) {
		if (sentence == null || sentence.length() < 26)
			return false;
		int mask = 0;

		for (char c : sentence.toCharArray()) {
			if (c >= 'a' && c <= 'z') {
				mask |= (1 << (c - 'a'));
				System.out.println("mask: "+ Integer.toBinaryString(mask));
				if (mask == (1 << 26) - 1) {
					return true;
				}
			}
		}

		return mask == (1 << 26) - 1;
	}
}
