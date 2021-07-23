//Time Complexity : O((k^cnt) *n), k -> Max number, cnt -> Count of numbers, n -> Length of string
// Space Complexity : O(sum(k^cnt) * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.Stack;

public class DecodeString {
	public String decodeString(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}

		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray()) {
			if (ch == ']') {
				sb.setLength(0);
				while (!stack.isEmpty() && stack.peek() != '[') {
					sb.append(stack.pop());
				}
				stack.pop();
				int cnt = 0;
				int base = 1;
				while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
					cnt = cnt + (stack.pop() - '0') * base;
					base *= 10;
				}
				for (int i = 0; i < cnt; i++) {
					for (int j = sb.length() - 1; j >= 0; j--) {
						stack.push(sb.charAt(j));
					}
				}
			} else {
				stack.push(ch);
			}
		}

		sb.setLength(0);
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		DecodeString obj = new DecodeString();
		String s = "2[abc]3[cd]ef";
		System.out.println("Decoded String: " + obj.decodeString(s));
	}

}
