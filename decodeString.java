// https://leetcode.com/problems/decode-string/

// Time Complexity: O(n) where n is length of the output string
// Space Complexity: O(h) h = maximum depth of the string
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: Took reference from lecture

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } else if (ch == '[') {
                strSt.push(currStr);
                numSt.push(num);
                currStr = new StringBuilder();
                num = 0;
            } else if (ch == ']') {
                int k = numSt.pop();
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < k; j++) {
                    temp.append(currStr);
                }
                StringBuilder parent = strSt.pop();
                currStr = parent.append(temp);
            } else {
                currStr.append(ch);
            }
        }
        return currStr.toString();
    }
}