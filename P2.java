/*
Time:O(nk)
Space:o(nk)

if [ then we push the num and current string into the stack and clear the variable holding the num and current string
if] then pop the number and iterate to append the string the number of times
*/

class Solution {
    public String decodeString(String s) {
         if(s.isEmpty()||s==null){
            return s;
        }
        Stack<Integer> nStack= new Stack<>();
        Stack<String> sStack= new Stack<>();
        int num = 0;
        String curr="";
        
        //iterate throught the string
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            
            //char is digit, compute the number ex: 32[a]
            if(Character.isDigit(c))
            {
                num = num*10 + c - '0';
            }
            
            else if( c == '[')
            {
                nStack.push(num);
                sStack.push(curr);
                
                //reset num and curr
                num=0;
                curr="";
            }
            
            else if(c == ']')
            {
                int temp = nStack.pop();
                StringBuilder sb = new StringBuilder();
                
                for(int j=0; j<temp; j++)
                {
                    sb.append(curr);
                }
                
                //adding previously added stack value
                curr =  sStack.pop() + sb.toString();
                
            }
            
             else
             {
              //if char then append the char value
              curr=curr+c;  
            }
        }
        
        return curr;
    }
}