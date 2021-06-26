// Time Complexity : O(K*N) // K is maximum number in the input string.
// Space Complexity :O(K*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


/*
 * 1. it is clear DFS problem as leaf node should be solved first to solve higher level
 * 2. use two stacks to save characters and number differently
 * 3. on [ insert it to stack and on ] form result string.
 */

import java.util.Stack;

public class DecodeString {

	public String decodeString(String s) {

		Stack<Integer> numStack = new Stack<>();
		Stack<StringBuilder> stringStack = new Stack<>();

		int curNum = 0;
		StringBuilder curBuilder = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				curNum = curNum * 10 + s.charAt(i)-'0';
			} else if (s.charAt(i) == '[') {
				numStack.add(curNum);
				stringStack.add(curBuilder);
				curNum = 0;
				curBuilder = new StringBuilder();
			} else if (s.charAt(i) == ']') {
				int num = numStack.pop();
				StringBuilder builder = stringStack.pop();
				for (int j = 0; j < num; j++) {
					builder.append(curBuilder);
				}
				curBuilder = builder;
			} else {
				curBuilder.append(s.charAt(i));
			}

		}
		return curBuilder.toString();

	}
	public static void main(String[] args) {
		
		System.out.println(new DecodeString().decodeString("3[a2[c]]4[s]"));
	}
}
