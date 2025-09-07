package com.java.dsa.google.leetcollection;

public class EncodeNum {

	public static void main(String[] args) {
		
		String s1="0";
		String s2="999_999";
		String s3="1_000_000";
		String s4= "1_000_001";
		String s5="29_888_850";
		String s6="999_999_9";

			
		System.out.println(encodeNum(s1));
		System.out.println(encodeNum(s2));
		System.out.println(encodeNum(s3));
		System.out.println(encodeNum(s4));
		System.out.println(encodeNum(s5));
		System.out.println(encodeNum(s6));
	}

	
	public static String encodeNum(String s) {
		if(s.equals("0")) return "000000";
		
		StringBuilder sb = new StringBuilder();
		int n=0;
		
		for(char c: s.toCharArray()) {
			if(c!= '_') {
				n*=10;
				n+= c-'0';
			}
		}
		dfs(n,sb,6);
		return sb.toString().trim();
	}
	
	public static void dfs(int n, StringBuilder sb, int k) {
		int divisor= (int)Math.pow(10, k);
		if(k==0) {
			return;
		}
		if(n< divisor) {
			while(n>0) {
				sb.insert(0, n%10);
				n/=10;
			}
			while(sb.length()<6) {
				sb.insert(0, '0');
			}
			return;
		}
		if(n>=divisor) {
			if(sb.length()==0) {
				sb.insert(0, 'A');
				dfs(n-divisor, sb,k);
			}else {
				char c=sb.charAt(0);
				if(c!='Z') {
					sb.deleteCharAt(0);
					sb.insert(0, (char)(c+1));
					dfs(n-divisor, sb,k);
				}else {
					if(sb.length()<6) {
						sb.insert(0, 'A');
						dfs(n-divisor, sb,k);
					}
				}
			}
		}
	}
	
}
