// Time Complexity : O(n) n = len of string
// Space Complexity : O(n) n = len of string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public String decodeString(String s) {
        Stack<Integer> number = new Stack<>();
        Stack<StringBuilder> str = new Stack<>();
        int curNum = 0;
        StringBuilder curString = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) { // if the char is a digit, then update the number to number of times the current string has to be concatenated
                curNum = curNum*10+ ch - '0';
            } else if(ch == '[') { //  Push currently computer string and number to the stacks and reinitialise them
                number.push(curNum);
                str.push(curString);
                curNum = 0;
                curString = new StringBuilder();
            } else if(ch == ']') { // Pop the top element and update the final resultant string
                int itr = number.pop();
                StringBuilder temp = new StringBuilder();
                for(int j=0;j<itr;j++) {
                    temp.append(curString);
                }
                StringBuilder prevStr = str.pop();
                curString = prevStr.append(temp);
            } else { // Concat to the current string
                curString.append(ch);
            }
        }
        return curString.toString();
    }
}