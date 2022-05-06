// Time Complexity : O(len(result))
// Space Complexity : O(depth)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        
        int num = 0;
        StringBuilder string = new StringBuilder();
        for(char ch : s.toCharArray()) {
            
            if(Character.isDigit(ch)) {
                
                num = num * 10 + ( ch - '0');
        
            } else if(ch == '[') {
                
                strStack.push(string);
                numStack.push(num);
                num = 0;
                string = new StringBuilder();
                
            } else if(ch ==']') {
                int times = numStack.pop();
                StringBuilder newString = new StringBuilder();
                
                for(int i = 0; i < times; i++) {
                    newString.append(string);    
                }
                
                StringBuilder lastString = strStack.pop();
                
                string = lastString.append(newString);
                
            } else {
                
                string.append(ch);
            }
        }
        
        return string.toString();
    }
}
