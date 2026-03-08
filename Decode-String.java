// Time Complexity : O(n * k)
// Space Complexity : O(n * k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
Have 2 stacks to maintain the current number and current string. Iterate through the input string and identify
the case depending upon the condition. If number/character found, we simply update the currNum and curr string
values. If we find '[', it means we are decoding further to next level, so push the values of currNum and currStr
to their respective stacks and intialize them back to store further decoded values. If we find ']', it means we have
decoded subsection, so we need to append the decoded part for number stack's top number of times to the parent
string which can be obtained from top of string stack. Return the current string at last.
 */

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        int currNum = 0;
        StringBuilder currStr = new StringBuilder();

        for(int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch))
                currNum = currNum * 10 + ch - '0';
            else if(ch == '[') {
                numSt.push(currNum);
                strSt.push(currStr);
                currNum = 0;
                currStr = new StringBuilder();
            }
            else if(ch == ']') {
                StringBuilder parent = strSt.pop();
                int count = numSt.pop();
                for(int k = 0 ; k < count ; k++) {
                    parent.append(currStr);
                }
                currStr = parent;
            }
            else
                currStr.append(ch);
        }
        return currStr.toString();
    }
}