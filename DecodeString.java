import java.util.Stack;

// Time Complexity : Length of resultant string * max value of the string.
// Space Complexity : Stack space is used when nesting is present.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return "";

        // 2 stack solution

        // initial num and str
        StringBuilder currString = new StringBuilder();
        int num = 0;

        // num and str stacks
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        // moving character wise from left to right, have 4 options- char, number, [, ]
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) { // calculate num
                num = num * 10 + c - '0';
            } else if (c == '[') { // push values to the stack and reset num and str.
                numStack.push(num);
                strStack.push(currString);
                currString = new StringBuilder();
                num = 0;
            } else if (c == ']') { // repeat currstring numStack.pop() times and append to strStack.pop()
                int times = numStack.pop();
                StringBuilder newString = new StringBuilder();
                for (int j = 0; j < times; j++) {
                    newString.append(currString);
                }
                currString = strStack.pop().append(newString);
            } else {
                currString.append(c); // append current char to currstring
            }
        }
        return currString.toString();

    }
}