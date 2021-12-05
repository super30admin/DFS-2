// Time Complexity : O(n * max(k))
// Space Complexity : O[(m + n) + K]
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
import java.util.*;

class Solution {
    public String decodeString(String s) {
        String curString = "";
        int curNum = 0;
        
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                
                curNum = curNum * 10 + (c - '0');
                
            } else if (c == '[') {
                
                strStack.push(curString);
                numStack.push(curNum);
                
                curString = "";
                curNum = 0;
                
            } else if (c == ']') {
                
                int poppedNum = numStack.pop();
                String temp = "";
                
                for (int j = 0; j < poppedNum; j++) {
                    temp = temp + curString;
                }
                
                curString = strStack.pop() + temp;
                
            } else {
                
                curString = curString + c;
            }
        }
        return curString;
    }
}