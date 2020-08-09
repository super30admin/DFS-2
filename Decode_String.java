// Time Complexity :O(n), n is length of decoded string
// Space Complexity :O(n), n is length of input string
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

/* Using two stack to store numbers and strings respectively
 * Iterating through the given encoded string, if opening bracket is found, the current number and string is added to the respective stacks
 * If closing bracket, the stacks are popped, and the string is processed a number of times(by getting the number at top of numStack and multiply it with current string) and added to the result */

import java.util.*;
public class Decode_String {
	public String decodeString(String s) {
		//edge case
		if(s == null || s.length() == 0)
			return s;

		int num =0;	// current number
		StringBuilder currStr = new StringBuilder();	// current string

		Stack<Integer> numStack = new Stack<>();	// to keep track of numbers
		Stack<StringBuilder> strStack = new Stack<>();	// to keep track of strings
		
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);	//character at the each index

			if(Character.isDigit(c))
				num = num * 10 + c - '0';	 // find the number till the point by multiplying the original number by 10 and adding the curr digit to it

			else if(c == '['){	// opening bracket  means new num and string to be encountered
				numStack.push(num);
				strStack.push(currStr);
				num = 0;	// reset current number
				currStr = new StringBuilder();	// reset current string
			}

			else if(c == ']'){	// closing bracket means we need to process
				int times = numStack.pop();	// get the number at top of numStack
				StringBuilder newString =  new StringBuilder();
				for(int k=0; k<times; k++)	// multiply the current string by number at top
					newString.append(currStr);

				currStr = strStack.pop().append(newString);	// append the character at top of stack to it
			}
			else
				currStr.append(c);
		}
		return currStr.toString();
	}
}
