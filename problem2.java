// Problem1 - https://leetcode.com/problems/decode-string/

// Time Complexity : O(length of output string)
// Space Complexity :O(number of opening brackets)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing as such
class DFS {
    public String decodeString(String s) {
        Stack<StringBuilder> strSt = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                strSt.push(currStr);
                numSt.push(num);
                currStr = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                int k = numSt.pop();
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < k; j++) {
                    temp.append(currStr);
                }
                StringBuilder parent = strSt.pop();
                currStr = parent.append(temp);
            } else {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}