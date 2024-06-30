// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    int i;

    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int num = 0;
        StringBuilder curr = new StringBuilder(); // resultant string and current situation of the string operations
        while (i < s.length()) { // global variable i 
            char c = s.charAt(i); // getting the character that we are operating on
            if (Character.isDigit(c)) { // check if number
                i++;
                num = num * 10 + (c - '0'); // creating number, 10 because if s is 23[a4[g]] -> 23 gets actual value and not 2 and 3
            } else if (c == '[') { 
                i++;
                String decoded = decodeString(s); // recursive, push to stack
                StringBuilder newStr = new StringBuilder(); 
                for (int j = 0; j < num; j++) {
                    newStr.append(decoded);
                }
                curr.append(newStr); // adding to resultant stack
                num = 0;
            } else if (c == ']') {
                i++;
                return curr.toString(); // return from recursive call, pop from stack
            } else {
                i++;
                curr.append(c);
            }
        }
        return curr.toString();
    }
}