// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public String decodeString(String s) {
        // return if string is empty
        if(s == "") return s;
        int num = 0;
        StringBuilder currStr = new StringBuilder();
        // intialize different stacks for string and numbers
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        // iterate through the string
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // check if the character is digit, then update the number variable
            if(Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if(c == '[') { // in case of openeing bracket, push the number in num stack
                // push the current string in string stack
                // reset the number variable and current string
                numStack.push(num);
                strStack.push(currStr);
                num = 0;
                currStr = new StringBuilder();
            } else if(c ==']') {
                // in case of closing bracket, pop from number stack and
                // append to current string repeatedly equal to number
                int times = numStack.pop();
                StringBuilder decoded = new StringBuilder();
                for(int j = 0; j < times; j++) {
                    decoded.append(currStr);
                }
                // pop from string stack and append current string to it
                currStr = strStack.pop().append(decoded);
            } else {
                // case else keep appending to current string
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}