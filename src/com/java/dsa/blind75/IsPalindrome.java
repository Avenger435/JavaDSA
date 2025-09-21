/**
 * 
 */
package com.java.dsa.blind75;

/**
 * 
 */
public class IsPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "A man, a plan, a canal: Panama";
//		String s = "race a car";
//		String s = "0P";
//		boolean palindrome = isPalindrome(s);
//		System.out.println("Is palindrome: " + palindrome);
		System.out.println("validPalindrome: "+ validPalindrome(s));
	}

	// ASCII range - A-Z =65-90 a-z= 61-7A

	// return s.equals(new StringBuilder(s).reverse().toString());

	public static boolean isPalindromeNonTwoPointer(String s) {

		StringBuilder sb = new StringBuilder();
		for (char ch : s.toLowerCase().toCharArray()) {
			if (Character.isLetterOrDigit(ch)) {
				sb.append(ch);
			}
		}
		return sb.toString().equals(sb.reverse().toString());

	}

	public static boolean validPalindrome(String s) {

		if (s == null || s.isEmpty())
			return false;

		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			while (left < right && Character.isLetterOrDigit(s.charAt(left)))
				left++;
			while (left < right && Character.isLetterOrDigit(s.charAt(right)))
				right--;

			if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
				return false;

			left++;
			right--;
		}
		return true;
	}

	public static boolean isPalindrome(String s) {

		// build the StringBuilder removing special chars.
		StringBuilder cleaned = new StringBuilder();
		for (char ch : s.toCharArray()) {
			// append to SB only if the char is digit or Letter.. removing special chars
			if (Character.isLetterOrDigit(ch)) {
				cleaned.append(Character.toLowerCase(ch));
			}
		}
		// initialize two pointers. left and right.
		int left = 0;
		int right = cleaned.length() - 1;

		// compare chars and move inwards.
		while (left < right) {
			if (cleaned.charAt(left) != cleaned.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}

		return true;
	}

}
