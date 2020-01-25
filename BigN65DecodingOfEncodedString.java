// Time complexity is O(N) as we are processing each element.
// Space complexity is O(n) as we are using two stack and both stack can have the maximum of length of the input string.
// This solution is submitted on leetcode

import java.util.Stack;

public class BigN65DecodingOfEncodedString {
	public String decodeString(String s) {
		Stack<Integer> num = new Stack<>();
		Stack<String> str = new Stack<>();
		int currNum = 0;
		String currString = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				currNum = 10 * currNum + c - '0';
			} else if (c == '[') {
				num.push(currNum);
				str.push(currString);
				currNum = 0;
				currString = "";
			} else if (c == ']') {
				int time = num.pop();
				StringBuilder strBuild = new StringBuilder();
				for (int k = 0; k < time; k++) {
					strBuild.append(currString);
				}
				currString = str.pop();
				currString += strBuild;
			} else {
				currString += c;
			}
		}
		return currString;
	}
}