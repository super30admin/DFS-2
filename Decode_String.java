// 394. Decode String - https://leetcode.com/problems/decode-string/
// Time Complexity : O(kN) where k is number and n is length of string
// Space Complexity : O(kN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public String decodeString(String s) {
        if(s==null || s.length() == 0) return s;
        
        int num = 0;
        StringBuilder currStr = new StringBuilder();
        
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            
            // digit
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            //[
            else if(c == '['){
                // push number and string to stacks
                numStack.push(num);
                strStack.push(currStr);
                // reset both
                num = 0;
                currStr = new StringBuilder();
            }
            //]
            else if(c == ']'){
                // pop the number
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                
                // build the string
                for(int k =0; k<times; k++){
                    newStr.append(currStr);
                }
                
                // combine with the parent
                StringBuilder parent = strStack.pop();
                currStr = parent.append(newStr);
            }
            // character
            else{
                currStr.append(c);
            }
        }
        return currStr.toString();
    
    }
}