// Time Complexity : O(nk) --> where n is the length of input string and k is the length of substring
// Space Complexity : O(n + k)
// Did this code successfully run on Leetcode (394): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public String decodeString(String s) {
        // edge
        if (s == null || s.length() == 0) return s;
        
        int currNum = 0;
        StringBuilder currStr = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // case 1
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
            }
            // case 2
            else if (c == '[') {
                numStack.push(currNum);
                strStack.push(currStr);
                currNum = 0;
                currStr = new StringBuilder();
            }
            // case 3
            else if (c == ']') {
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for (int j = 0; j < times; j++) {
                    newStr.append(currStr);
                }
                currStr = strStack.pop().append(newStr);
            }
            // case 4 - if character is alphabet
            else {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}