// Time Complexity : O(k*n) k - times to decode each pattern, n - length of the string
// Space Complexity : O(m+n) max size of the two stack
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> strSt = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int currNum = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
            } else if(c == '[') {
                numSt.push(currNum);
                strSt.push(currStr);
                currStr = new StringBuilder();
                currNum = 0;
            } else if(c == ']') {
                // decoding the curr baby
                int times = numSt.pop();
                StringBuilder sb = new StringBuilder();
                for(int k = 0; k < times; k++) {
                    sb.append(currStr);
                }
                currStr = strSt.pop().append(sb);
            } else {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}