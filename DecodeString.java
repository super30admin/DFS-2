// Time Complexity : O(k*n) 
// Space Complexity : O(k*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
class Solution {
    public String decodeString(String s) {
        // Base case
        if (s == null || s.length() == 0) return "";

        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int num = 0;
        StringBuilder currStr = new StringBuilder();

        for (int i=0; i< s.length(); i++) {
            char c = s.charAt(i);

            // condition checks for the character
            if (Character.isDigit(c)) {
                // If character is a digit
                num = num *10 + (c - '0');

            } else if (c == '[') {
                // If character is [, push to stack
                strStack.push(currStr);
                currStr = new StringBuilder();
                numStack.push(num);
                num = 0;
            } else if (c == ']') {
                // If character is ], pop from stack
                StringBuilder newStr = new StringBuilder();
                int len = numStack.pop();
                for (int j = 0; j < len; j++) {
                    newStr.append(currStr);
                }
                currStr = strStack.pop().append(newStr);

            } else {
                // It is any other character within the constraints
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}
