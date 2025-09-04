package com.java.dsa.google;

public class PalindromeNum {

    public static void main(String[] args) {
        int val = 121;
        System.out.println(isPalindrome(val));
    }

    /**
     * Checks if the given integer is a palindrome.
     * <p>
     * A palindrome number is a number that remains the same when its digits are reversed.
     * Negative numbers are not considered palindromes.
     *
     * @param x the integer to check
     * @return {@code true} if {@code x} is a palindrome, {@code false} otherwise
     */
    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int original = x;
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        return original == reversed;
    }

}
