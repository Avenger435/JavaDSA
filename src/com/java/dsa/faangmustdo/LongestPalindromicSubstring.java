package com.java.dsa.faangmustdo;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {

        String s = "babad";
        // Output: "bab" or "aba"
        var result = longestPalindrome(s);
        System.out.println("Longest Palindromic Substring: " + result);
    }

    public static String longestPalindrome(String s) {

        // Edge case: if the string is null or empty, return an empty string
        // This handles cases where the input string is null or has no characters
        if (s == null || s.length() == 0)
            return "";

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            int len1 = expand(s, i, i); // odd
            int len2 = expand(s, i, i + 1);// even
            int len= Math.max(len1, len2);

            while(len > end -start){
                start = i - (len-1)/2;
                end= i + len/2;
            }

        }

        return s.substring(start,end +1);
    }

    public static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
