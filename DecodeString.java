// Time Complexity : O(mn)
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
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
                int n = numSt.pop();
                StringBuilder temp = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    temp.append(currStr);
                }
                currStr = strSt.pop().append(temp);
            } else {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
} 
