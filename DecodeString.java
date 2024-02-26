// Time Complexity : O(product of nested numbers or max individual number)
// Space Complexity : O(max nested strings * average string length)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Used number and str stack to keep track of parent and child
// whenever a closing bracket is found; that means child is finished processing
// add it to the parent string the required number of times

import java.util.Stack;

class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> numberSt = new Stack();
        Stack<StringBuilder> strStack = new Stack();
        int currNumber = 0;
        // empty string
        StringBuilder currStr = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (Character.isDigit(curr)) {
                // could have used parseInt too
                int value = curr - '0';
                currNumber = currNumber * 10 + value;
            } else if (Character.isAlphabetic(curr)) {
                currStr.append(curr);
            } else if (curr == '[') {
                strStack.push(currStr);
                numberSt.push(currNumber);
                // reset currString and currNumber
                currStr = new StringBuilder();
                currNumber = 0;
            } else {
                StringBuilder parentStr = strStack.pop();
                int parentNum = numberSt.pop();

                while (parentNum != 0) {
                    parentStr.append(currStr);
                    parentNum--;
                }
                currStr = parentStr;
            }
        }

        return currStr.toString();
    }
}