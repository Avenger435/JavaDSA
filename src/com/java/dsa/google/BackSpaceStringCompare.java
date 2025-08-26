/**
 * 
 */
package com.java.dsa.google;

import java.util.Stack;

/**
 * 
 */
public class BackSpaceStringCompare {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Case 1: " + (backspaceCompare("ab#c", "ad#c") == true));
		System.out.println("Case 2: " + (backspaceCompare("ab##", "c#d#") == true));
		System.out.println("Case 1: " + (backspaceCompare("a#c", "b") == false));
		System.out.println("Case 1: " + (backspaceCompare("#a#c", "c") == true));
	}

	public static boolean backspaceCompare(String s, String t) {

		return processString(s).equals(processString(t));
	}

	/**
	 * Traverse both from the end, skipping characters based on backspace counts.
	 * 
	 * @param s
	 * @return
	 */
	private static String processString(String s) {
		StringBuilder sb = new StringBuilder();
		// keep the counter for number of # in the string
		int skip = 0;
		// iterate from the back.
		for (int index = s.length() - 1; index >= 0; index--) {
			// increment the counter when # is encountered,
			// we use this to skip chars that are not followed by #
			if (s.charAt(index) == '#') {
				skip++;
			} else {
				// if we have skip count, reduce counter
				if (skip > 0) {
					skip--;
				}
				// else, we append the char to out String builder
				else {
					sb.append(s.charAt(index));
				}
			}
		}
		return sb.toString();
	}

	private static String processString1(String s) {

		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (ch != '#') {
				stack.push(ch);
			} else {
				if (!stack.isEmpty())
					stack.pop();
			}
		}

		StringBuilder sb = new StringBuilder();
		for (char ch : stack)
			sb.append(ch);
		return sb.toString();

	}
}
