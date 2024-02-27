// Time Complexity : O(n * max(K)) [n: length of string; k: max of numbers in the string]
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 *I'm iterating through the string and acting when I find number OR Alpha character OR '[' OR ']' 
 *  I push num in the stack when I find '[' and pop everything from stack when i found ']' 
 * I multiply the result cnt no. of times and append the result to current str
*/

import java.util.Stack;

class Solution {
    int i;
    public String decodeString(String s) {
        // return helperIterativeStack(s);
        return helperRecursion(s);
    }

    private String helperRecursion(String s) {
        char zero = '0';
        int currNum = 0;
        StringBuilder currStrB = new StringBuilder();
        while(i < s.length()) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                currNum = currNum * 10 + ch - zero;
                 i++;
            } else if(ch == '[') {
                i++;
                String baby = helperRecursion(s);
                for(int j = 0; j< currNum; j++) {
                   currStrB.append(baby); 
                }
                currNum = 0;
            } else if(ch == ']') {
                i++;
                return currStrB.toString();

            }else {
                currStrB.append(ch);
                i++;
            }
        }
        return currStrB.toString();
    }

    private String helperIterativeStack(String s) {
        char zero = '0';
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        StringBuilder currStrB = new StringBuilder();
        int currNum = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                currNum = currNum * 10 + ch - zero;
            } else if (ch == '[') {
                numSt.push(currNum);
                currNum = 0;
                strSt.push(currStrB);
                currStrB = new StringBuilder();
            } else if (ch == ']') {
                int cnt = numSt.pop();
                StringBuilder parent = strSt.pop();
                StringBuilder decodedbaby = new StringBuilder();
                for (int j = 0; j < cnt; j++) {
                    decodedbaby.append(currStrB);
                    // parent.append(currStrB);
                }
                // currStrB = parent;
                currStrB = parent.append(decodedbaby);
            } else {
                currStrB.append(ch);
            }
        }
        return currStrB.toString();
    }
}