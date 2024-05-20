// Time Complexity : O(L) - where L is the length of the output string
// Space Complexity : O(n) - stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// USing 2 stacks approach - one stack for numbers and other stack for strings
class Solution {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();

        int currNum =0;
        StringBuilder currStr = new StringBuilder();

        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);

            if(Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
            }else if(c == '['){
                numSt.push(currNum);
                strSt.push(currStr);
                currNum = 0;
                currStr = new StringBuilder();
            }else if(c == ']') {
                int num = numSt.pop();
                StringBuilder innerStr = new StringBuilder();
                for(int j= 0;j<num;j++) {
                    innerStr.append(currStr);
                }
                StringBuilder outerStr = strSt.pop();
                outerStr.append(innerStr);
                currStr = outerStr;
            }else {
                currStr.append(c);
            }
        }

        return currStr.toString();
    }
}

// Recursive Approach
class Solution {
    int i=0;
    public String decodeString(String s) {
        int currNum =0;
        StringBuilder currStr = new StringBuilder();

        while(i < s.length()) {
            char c = s.charAt(i);
            i++;
            if(Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
            }else if(c == '[') {
                String inner = decodeString(s);
                for(int k=0;k<currNum;k++) {
                    currStr.append(inner);
                }
                currNum =0;
            }else if(c == ']') {
                return currStr.toString();
            }else {
                currStr.append(c);
            }
        }

        return currStr.toString();
    }
}