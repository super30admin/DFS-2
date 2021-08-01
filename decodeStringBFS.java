// Time Complexity : O(kN)
// Space Complexity : O(kN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
import java.util.Stack;

class decode {
    public String decodeString(String s) {
        if(s == null || s.length() == 0)
            return s;
        
        int num = 0;
        StringBuilder currStr = new StringBuilder();
        
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            //digit
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
                
            }
            //[
            else if(c == '['){
                numStack.push(num);
                strStack.push(currStr);
                
                num = 0;
                currStr = new StringBuilder();
                
            }
            else if(c == ']'){
                //pop the number
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                //build the string
                for(int k = 0; k < times; k++){
                    newStr.append(currStr);
                }
                
                //combine with parent
                StringBuilder parent = strStack.pop();
                currStr = parent.append(newStr);
                
            }
            else{
                currStr.append(c);
            }
        }
        
        return currStr.toString();
    }
}