import java.util.*;

//Time Complexity : o(max(k)*n) - k is largest num and n is length of the string
//Space Complexity : o(m+n) m - no of digits, n - no of letters
//Did this code successfully run on Leetcode: Yes
public class DecodeString {

	public String decodeString(String s) {

		if (s == null || s.length() == 0)
			return s;
		Stack<StringBuilder> str = new Stack<>();
		Stack<Integer> num = new Stack<>();
		StringBuilder currS = new StringBuilder();
		int currNum = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			//check curr index character 
			//iff digit convert it to number
			if (Character.isDigit(c)) {
				currNum = currNum * 10 + c - '0';
			} 
			//opening brackets then push curr characters and numbers to stack and reset for next
			else if (c == '[') {
				str.add(currS);
				num.add(currNum);
				currS = new StringBuilder();
				currNum = 0;
			} 
			// closing bracket then decode the inner curr strings k Num of times
			//and append to next string
			else if (c == ']') {
				int times = num.pop();
				StringBuilder newS = new StringBuilder();
				for (int k = 0; k < times; k++) {
					newS.append(currS);
				}
				currS = str.pop().append(newS);
			} 
			//keeping appending to curr string
			else {
				currS.append(c);
			}
		}
		return currS.toString();
	}

}
