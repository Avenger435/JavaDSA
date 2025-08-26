/**
 * 
 */
package com.java.dsa.google;

/**
 * 
 */
public class LongPressedName {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(isLongPressedName("allex", "aalex"));
		System.out.println(isLongPressedName("saeed", "ssaaedd"));

	}

	public static boolean isLongPressedName(String name, String typed) {
		int i = 0;
		int j = 0;

		while (j < typed.length()) {
			if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
				i++;// move both pointers when the chars match
			} else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1)) {
				return false; // invalid long press.
			}
			j++;
		}
		return i == name.length(); // all chars in 'name' should be matched.
	}

}
