// Time Complexity : (N) N=length of string
// Space Complexity : O(2N) 2 stacks of size N
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    Add operations into stack and po them whenwe see closing brackets   
*/


// Your code here along with comments explaining your approach
class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return s;
        int num = 0; StringBuilder currStr = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            
            if(Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if(c == '[') {
                numStack.push(num);
                strStack.push(currStr);
                num = 0;
                currStr = new StringBuilder();
            } else if(c == ']') {
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for(int k=0;k<times;k++) {
                    newStr.append(currStr);
                }
                StringBuilder parent = strStack.pop();
                currStr = parent.append(newStr);
            } else {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}
