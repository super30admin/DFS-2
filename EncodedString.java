//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

import java.util.Stack;

public class EncodedString {
	class Solution {
		public String decodeString(String s) {
			if (s == null || s.length() == 0)
				return s;
			Stack<String> str = new Stack<>();
			Stack<Integer> num = new Stack<>();
			int currNum = 0;
			String currStr = "";
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (Character.isDigit(c)) {
					currNum = currNum * 10 + c - '0';
				} else if (c == '[') {
					num.push(currNum);
					str.push(currStr);
					currNum = 0;
					currStr = "";
				} else if (c == ']') {
					StringBuilder newStr = new StringBuilder();
					int time = num.pop();
					for (int k = 0; k < time; k++) {
						newStr.append(currStr);
					}
					currStr = str.pop() + newStr;
				} else {
					currStr += c;
				}
			}
			return currStr;
		}
	}
}
