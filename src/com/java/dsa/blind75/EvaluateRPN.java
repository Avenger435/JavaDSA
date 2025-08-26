/**
 * 
 */
package com.java.dsa.blind75;

import java.util.Stack;

/**
 * 
 */
public class EvaluateRPN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String[] tokens = { "2", "1", "+", "3", "*" }; // 9
		String[] tokens2 = { "4", "13", "5", "/", "+" }; // 6
		String[] tokens3 = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };

		int evalRPN = evalRPN(tokens);
		System.out.println("evalRPN: " + evalRPN);

		int evalRPN2 = evalRPN(tokens2);
		System.out.println("evalRPN2: " + evalRPN2);

		int evalRPN3 = evalRPN(tokens3);
		System.out.println("evalRPN3: " + evalRPN3);

	}

	public static int evalRPN(String[] tokens) {
		int res = 0;
		String operators = "+-*/";
		Stack<String> stack = new Stack<>();

		for (String token : tokens) {
			if (!operators.contains(token)) {
				stack.push(token);
			} else {
//				System.out.println("Stack : " + stack);
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				int index = operators.indexOf(token);
				switch (index) {
				case 0:
					stack.push(String.valueOf(a + b));
					break;
				case 1:
					stack.push(String.valueOf(b - a));
					break;
				case 2:
					stack.push(String.valueOf(a * b));
					break;
				case 3:
					stack.push(String.valueOf(b / a));
					break;
				}
			}

		}
		res = Integer.valueOf(stack.pop());
		return res;
	}

	//fast solution
	class Solution {
	    int i;
	    public int evalRPN(String[] tokens) {
	        i = tokens.length;
	        return eval(tokens);
	    }
	    public int eval(String[] tokens) {
	        String currentString = tokens[--i];
	        int k = 0, num = 0, sign = 1;
	        char s = currentString.charAt(0);
	        if (currentString.length() == 1) {
	            switch (s) {
	                case '+':
	                    return eval(tokens) + eval(tokens);
	                case '-':
	                    return -eval(tokens) + eval(tokens);
	                case '*':
	                    return eval(tokens) * eval(tokens);
	                case '/':
	                    int second = eval(tokens);
	                    int first = eval(tokens);
	                    return first / second;
	                default:
	                    return s - '0';
	            }
	        }
	        else {
	            if (s == '-') {
	                sign = -1;
	                k++;
	            }
	            while (k < currentString.length()) {
	                s = currentString.charAt(k++);
	                num = num * 10 + s - '0';
	            }
	            return num * sign;
	        }
	    }
	}
	
}
