// Time Complexity : O(n*max repeat size ^^ max number of nested brackets) 
//n is the size of the alphabets in the string
// Space Complexity : O(n)+O(max repeat size ^^ max number of nested brackets)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this : N

// Your code here along with comments explaining your approach
class Solution {
    public String decodeString(String s) {
        if (s.length() == 0 || s == null)
            return s;

        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        int num = 0;
        StringBuilder curr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(num);
                strStack.push(curr);
                num = 0;
                curr = new StringBuilder();
            } else if (c == ']') {
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for (int j = 0; j < times; j++) {
                    newStr.append(curr);
                }
                curr = strStack.pop().append(newStr);
            } else {
                curr.append(c);
            }
        }
        return curr.toString();
    }
}