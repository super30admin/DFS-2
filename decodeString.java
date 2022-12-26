// Time Complexity : O(len of decoded string)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three
// sentences only
/*
 * we maintain 2 stack- one for num and 1 for the string
 * maintain a currStr and currNum variable to keep track of the string for every new character from the string s.
 * check 4 cases and accordingly generate the decoded string
 */
class Solution {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int currNum = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
            } else if (c == '[') {
                strSt.push(currStr);
                numSt.push(currNum);
                currStr = new StringBuilder();
                currNum = 0;
            } else if (c == ']') {
                int count = numSt.pop();
                StringBuilder str = new StringBuilder();
                for (int j = 0; j < count; j++) {
                    str.append(currStr);
                }
                StringBuilder mainStr = strSt.pop();
                currStr = mainStr.append(str);
            } else {
                // alphabet
                currStr.append(c);
            }
        }

        return currStr.toString();
    }
}