package org.greatlearning.dsa.problem1;

import java.util.Stack;

class BalancedBracket {
	public static boolean isStringBalanced(String bracketExpression) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < bracketExpression.length(); i++) {
			char ch = bracketExpression.charAt(i);
			if (ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
				continue;
			}
			if (stack.isEmpty()) {
				return false;
			}
			char c;
			switch (ch) {
			case '}':
				c = stack.pop();
				if (c == '(' || c == '[')
					return false;
				break;
			case ')':
				c = stack.pop();
				if (c == '{' || c == '[')
					return false;
				break;
			case ']':
				c = stack.pop();
				if (c == '(' || c == '{')
					break;
			default:
				break;
			}
		}
		return (stack.isEmpty());
	}

	public static void main(String s[]) {
		String expr = "([[{}]])";
		boolean res = isStringBalanced(expr);
		if (res) {
			System.out.println("The entered String has Balanced Brackets");
		} else
			System.out.println(" The entered String does not have Balanced Brackets");
	}
}
