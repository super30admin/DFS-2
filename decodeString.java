// Time Complexity = O(max no. * n)
// Space Complexity = O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        int num=0;
        StringBuilder currStr = new StringBuilder();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {      // digit case
                num = num * 10 + (c-'0');   // since the number might be more than 1 digit
            }
            else if(c == '[') {
                numStack.push(num);
                strStack.push(currStr);
                currStr = new StringBuilder();
                num=0;
            }
            else if(c == ']') {
                int times = numStack.pop();
                StringBuilder tempStr = new StringBuilder();

                for(int j=0; j<times; j++) {
                    tempStr.append(currStr);
                }
                currStr = strStack.pop().append(tempStr);
            }
            else {                          // character case
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}