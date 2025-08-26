package com.java.dsa.google;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmail {

	public static void main(String[] args) {

		String[] emails = { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
				"testemail+david@lee.tcode.com" };

		String[] emails1 = { "a@leetcode.com", "b@leetcode.com", "c@leetcode.com" };

		String[] emails2 = { "test.email+alex@leetcode.com", "test.email@leetcode.com" };

		System.out.println(numUniqueEmails(emails2));
		;

//		int numUniqueEmails = numUniqueEmails(emails);
//		int num1 = numUniqueEmails(emails1);
//		System.out.println(numUniqueEmails);
//		System.out.println(num1);

	}

	public static int numUniqueEmails(String[] emails) {
		Set<String> uniqueEmails = new HashSet<>();
		for (String email : emails) {
			int atIndex = email.indexOf('@');
			StringBuilder sb = new StringBuilder();
			for (char c : email.substring(0, atIndex).toCharArray()) {
				if (c == '+')
					break;
				if (c != '.')
					sb.append(c);
			}
			uniqueEmails.add(sb.toString() + "@" + email.substring(atIndex + 1));
		}
		return uniqueEmails.size();
	}

	public static int numUniqueEmails1(String[] emails) {
		Set<String> uniqueEmails = new HashSet<>();
		for (String email : emails) {
			String[] parts = email.split("@");
			String local = parts[0];
			String domain = parts[1];
			local = local.split("\\+")[0].replace(".", "");

			String normalised = local + '@' + domain;
			uniqueEmails.add(normalised);
		}

		System.out.println(uniqueEmails);
		return uniqueEmails.size();
	}

}
