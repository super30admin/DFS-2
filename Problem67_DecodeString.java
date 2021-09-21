// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public String decodeString(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<String> str = new Stack<>();
        String currStr = "";
        int currNum = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) 
                currNum = currNum * 10 + c - '0';
            else if(c == '[') {
                num.push(currNum);
                str.push(currStr);
                currNum = 0;
                currStr = "";
            } else if(c == ']') {
                int times = num.pop();
                StringBuilder newStr = new StringBuilder();
                for(int j = 0; j < times; j++) {
                    newStr.append(currStr);
                }
                currStr = str.pop();
                currStr = currStr + newStr;
            } else {
                currStr += c;
            }
        }
        return currStr;
    }
}