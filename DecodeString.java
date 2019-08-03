package dfs2;

import java.util.Stack;

/*
Idea :  1. We use two stacks, one for storing digits and one for characters.
 		2. Iterate over the string character-wise and separate them according to 4 conditions, 
 		   then append to form resultant string..

Time Complexity : O(n) where n is length of given string.
Space Complexity : O(n) where n is the length of given string. 
					{it can be more if res stores already computed characters 
					e.g. 3[a4[cd]] : res = cdcdcdcd after some iteration.}
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
*/

public class DecodeString {
	public static String decodeString(String s) {
        String res = "";
        
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        // iteration through the string
        while (idx < s.length()) {
        	// if digit is encountered
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            // if [ is encountered
            else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }
            // if ] appears
            else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                // this loop repeats the character string in the brackets for number outside the []s.
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
            	// appending the characters in this res variable helps to maintain order of characters 
                res += s.charAt(idx++);
            }
        }
        return res;
    }
    
	
	// Driver method 
    public static void main(String args[]) 
    { 
        String str = "3[ca]"; 
        System.out.println(decodeString(str)); 
    }
}
