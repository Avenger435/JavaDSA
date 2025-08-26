/**
 * 
 */
package com.java.dsa.googletop50;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 */
public class FindDifferenceString {

	public static void main(String[] args) {
		String s = "a", t = "aa";
		char theDifference = findTheDifference(s, t);

		System.out.println("theDifference: " + theDifference);
	}

	public static char findTheDifference(String s, String t) {

		Set<Character> onlyInMap1 = new HashSet<>(buildFrequencyMap(t).keySet());
		onlyInMap1.removeAll(buildFrequencyMap(s).keySet());
		return onlyInMap1.iterator().next();

	}

	/**
	 * @param s
	 */
	public static Map<Character, Integer> buildFrequencyMap(String s) {
		Map<Character, Integer> freqMap = new HashMap<>();
		for (Character ch : s.toCharArray()) {
			freqMap.put(ch, freqMap.getOrDefault(freqMap, 0) + 1);
		}
		return freqMap;
	}

}
