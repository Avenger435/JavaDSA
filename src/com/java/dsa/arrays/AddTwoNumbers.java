package com.java.dsa.arrays;

import java.util.Scanner;

public class AddTwoNumbers {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter the first number:");
			double num1 = scanner.nextDouble();

			System.out.println("Enter the second number:");
			double num2 = scanner.nextDouble();

			double sum = num1 + num2;
			System.out.printf("%.2f plus %.2f equals %.2f\n", num1, num2, sum);
		}
	}
}