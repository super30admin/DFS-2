
// Time Complexity : O(M), where M is length of decoded string
// Space Complexity : O(N), where N is length of encoded string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;

public class decode_string {
	public String decodeString(String s) {
		if (s == null || s.length() == 0)
			return s;
		Stack<Integer> num_stack = new Stack<>();
		Stack<StringBuilder> curr_str = new Stack<>();
		int num = 0;
		StringBuilder curr = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			// case 1
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				num = num * 10 + c - '0';
			}
			// case 2
			else if (c == '[') {
				num_stack.push(num);
				curr_str.push(curr);
				num = 0;
				curr = new StringBuilder();
			}
			// case 3
			else if (c == ']') {
				int times = num_stack.pop();
				StringBuilder newString = new StringBuilder();
				for (int k = 0; k < times; k++) {
					newString.append(curr);
				}
				curr = curr_str.pop().append(newString);
			}
			// case 4
			else {
				curr.append(c);
			}
		}
		return curr.toString();
	}
}