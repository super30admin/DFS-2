// Time Complexity :  O(n × k) where n is the length of the string and k is the maximum repeat count
// Space Complexity : O(n × k) 
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
We loop through the string and keep track of the digits and characters visited
when we encounter open braces we push the current number and string into the two different stacks maintained for integer and characters
when we encounter an closed brace we pop the top most integer from integer stack and string from string stack and decode the string
*/
class Solution {
    public String decodeString(String s) {
        Stack<Integer> intSt = new Stack<>();
        Stack<StringBuilder> stSt = new Stack<>();
        int curNum = 0;
        StringBuilder curStr = new StringBuilder();
        for(int i = 0; i< s.length();i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                //digit only update the current number var
                curNum = curNum*10 + (ch - '0');
            } else if(ch == '[') {
                //opening bracket only push the cur num and string to stack
                stSt.push(curStr);
                intSt.push(curNum);
                //reset the segments
                curStr = new StringBuilder();
                curNum = 0;

            } else if(ch == ']') {
                int repeat = intSt.pop();
                StringBuilder decodedStr = stSt.pop();
                for(int k = 0; k< repeat;k++) {
                    decodedStr.append(curStr); //repeat the string k times and append to the current stack string popped
                }
                curStr = decodedStr;//update the cur string to hold the decoded string
            } else {
                //alphabet
                curStr.append(ch);
            }
        }
        return curStr.toString();
        
    }
}
