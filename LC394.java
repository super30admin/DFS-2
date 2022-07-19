//Time Complexity : O(n)
//Space Complexity : O(n)

class Solution {
    public String decodeString(String s) {
        
        if(s == null)
        {
            return "";
        }
        
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        
        StringBuilder curr = new StringBuilder();
        int num = 0;
        
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch))
            {
                num = num*10 + ch - '0';
            }
            else if(ch == '[')
            {
                numStack.push(num);
                stringStack.push(curr);
                
                num = 0;
                curr = new StringBuilder();
            }
            else if(ch == ']')
            {
                int k = numStack.pop();
                
                StringBuilder decoded = new StringBuilder();
                
                for(int idx=0;idx<k;idx++)
                {
                    decoded.append(curr);
                }
                
                curr = stringStack.pop().append(decoded);
            }
            else
            {
                curr.append(ch);
            }
        }
        
        return curr.toString();
    }
}