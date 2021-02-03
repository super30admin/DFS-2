// Time Complexity : O(kn)
// Space Complexity : O(n) where n is the length of the decoded string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 2 stack approach
// 1 stack to keep a track of k's
// 2nd stack to keep track of corresponding strings

class Solution {
    public String decodeString(String s) {

        Stack<StringBuilder> strStack = new Stack();
        Stack<Integer> numStack = new Stack();

        StringBuilder curStr = new StringBuilder();
        int curNum = 0;

        for(char c : s.toCharArray()) {
           if(Character.isDigit(c)) {
               curNum =  curNum * 10 + c - '0';
           } else if (c == '[') { //Add to stacks

               numStack.push(curNum);
               strStack.push(curStr);

               curNum = 0;
               curStr = new StringBuilder();
           } else if (c == ']') { //Remove from stack and decode

               int k = numStack.pop();
               StringBuilder newStr = new StringBuilder();
               while(k > 0) {
                   newStr.append(curStr);
                   k--;
               }
               curStr = strStack.pop();
               curStr.append(newStr);
           } else { //char
                curStr.append(c);
           }
        }

        return curStr.toString();
    }


}
