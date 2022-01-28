// Time Complexity : O(n) where n is the size of the decoded string.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    int i;

    public String decodeString(String s) {
        if (s.length() == 0 || s == null)
            return s;
        // variable values pushed to respective stacks and then reset.
        int num = 0;
        StringBuilder curr = new StringBuilder();
        while (i < s.length()) {
            char c = s.charAt(i);
            // if it is a number
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
                i++;
            }
            // if [, push num and parent to stack and reset values
            else if (c == '[') {
                i++;
                // during each call to the function, the num and curr will be pushed and then in
                // the next call will be reset.
                String inner = decodeString(s);
                StringBuilder child = new StringBuilder();
                // multiply the inner string the given num of times
                // num and curr will be popped and value will be set from the stack after each
                // recursive call
                for (int i = 0; i < num; i++) {
                    child.append(inner);
                }
                // add to the parent
                curr = curr.append(child);
                // reset the number after use
                num = 0; // we don't need the number to be carried forward unlike the curr.
                // ]
            } else if (c == ']') {
                // increment pointer
                i++;
                // return the curr string back to the recursion at the closing brace... ex: cddd
                return curr.toString();
                // char
            } else {
                curr.append(c);
                i++;
            }
        }
        return curr.toString();
    }
}