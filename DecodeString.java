
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, with the formation of stacks


// Your code here along with comments explaining your approach
/*Approach:
1) we consider 2 stacks
               -> Integer Stack
               -> String Stack
2) we have a variable number (num) which we declare to have consecutive numbers accomdated as well as we process character by character.
suppose we have 3, num will store 3
if we have 38 then num = num*10+ character-'3' , in frst iteration number will be 3, then we have 38 thus we store it beforehand
3) if we encounter '[' then we push into the stack all the string and the number till now
4) if we encounter ']' we pop the string and number associated with it. 
5) This way we can accomplish the 

*/

import java.util.*;

class DecodeString {
    public String decodeString(String s) {
     
        if(s==null || s.length()==0)
        {
            return s;
        }
        
        int num=0;
        
        StringBuilder sb = new StringBuilder();
        
        Stack<Integer> numStack= new Stack<>();
    
        Stack<StringBuilder> strStack = new Stack<>();
        
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            
            if(Character.isDigit(c))
            {
                num=num*10 + (c-'0');
            }
            else if(c=='[')
            {
                numStack.push(num);
                strStack.push(sb);
                num=0;
                sb = new StringBuilder();
                
            }
            else if(c==']') 
            {
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for(int j=0;j<times;j++)
                {
                    newStr.append(sb);
                }

                // to accommodate the string popped and also the orginal string if it has been popped before
                sb=strStack.pop().append(newStr);
                
            }
            else
            {
                sb.append(c);
            }
            
            
        }
        
        return sb.toString();
    }
}