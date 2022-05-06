/**
 * Problem: https://leetcode.com/problems/decode-string/
*/

/** 
 * Approach 1: Iterative
 * TC: O(n) where n is the length of the RESULT string
 * SC: O(depth of nesting)
 **/
class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return s;
        
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int num = 0;
        StringBuilder curString = new StringBuilder();
        
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                num = num * 10 + Character.getNumericValue(c); // OR => num*= 10 + (c - '0')
            } else if(c == '[') {
                numStack.push(num);
                strStack.push(curString);
                num = 0;
                curString = new StringBuilder();
            } else if (c == ']') {
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for (int t = 0; t < times; ++t) {
                    newStr.append(curString);
                }
                curString = strStack.pop().append(newStr);
            } else { // character
                curString.append(c);
            }
        }
        return curString.toString();
    }
}

/*
Approach 2: Recursion
TC: O(n) where n is the length of the result string
SC: O(depth of nesting)
*/
class Solution {
    int i;
    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return s;
        
        int num = 0;
        StringBuilder curString = new StringBuilder();
        
        while (i < s.length()) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                num = num * 10 + Character.getNumericValue(c); // OR => num*= 10 + (c - '0')
                ++i;
            } else if(c == '[') {
                ++i;
                String decoded = decodeString(s);
                StringBuilder newStr = new StringBuilder();
                for (int t = 0; t < num; ++t) {
                    newStr.append(decoded);
                }
                curString.append(newStr);
                num = 0;
            } else if (c == ']') {
                ++i;
                return curString.toString();
            } else { // character
                ++i;
                curString.append(c);
            }
        }
        return curString.toString();
    }
}