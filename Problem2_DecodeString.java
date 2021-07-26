// Time Complexity : o(kN) WHERE K is number and N is length string
// Space Complexity : o(KN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public String decodeString(String s) {
        
        if(s==null||s.length()==0)
            return s;
        
        int num=0;
        StringBuilder currString=new StringBuilder();
        
        Stack<Integer> numStack=new Stack<>();
        Stack<StringBuilder> strStack=new Stack<>();
        
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            
            //digit
            if(Character.isDigit(c))
            {
                num=num*10+c-'0';
                
            }
            else if(c == '[')
            {
                //push num and curr string to stack
                numStack.push(num);
                strStack.push(currString);
                // reset to 0 and ""
                num=0;
                currString=new StringBuilder();
            }
            else if(c == ']')
            {
                //pop the number
                int times=numStack.pop();
                
                StringBuilder newStr=new StringBuilder();
                
                for(int j=0;j<times;j++)
                {
                    newStr.append(currString);
                }
                //pop and combining with parent the curr string
                StringBuilder parent=strStack.pop();
                currString=parent.append(newStr);
            }
            else
            {
                currString.append(c);
            }
        }
        return currString.toString();
    }
}