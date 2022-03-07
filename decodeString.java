/**
problem statement
Ask clarifying questions
solutions
Brute force TC, SC.
optimal approach TC, SC.
walk through the solution.
Follow up Q&A.

s = "3[a2[c]]"

stack   3 [ a 2 [ 
temp = c

"3[a]2[bc]"

// Using Stack Approach.

**/
class Solution {
    public String decodeString(String s) {
        
        Stack<String> stack = new Stack<>();
        
        for (int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            
            if (c == ']')
            {
                String temp = "";
                
                while (!stack.isEmpty() && !stack.peek().equals("["))
                {
                    String pop = stack.pop();
                    temp = pop + temp;
                }
                
                System.out.println("Temp:"+temp);
                
                stack.pop();
                
                String number = "";
                
                while(!stack.isEmpty() && isStringANumber(stack.peek()))
                {
                    number = stack.pop() + number;
                }
                
                // convert string to number
                int times = Integer.parseInt(number);
                
                System.out.println("Times :"+times);
                
                // build the string to that times
                StringBuilder sb = new StringBuilder();
                
                for (int k=0; k<times; k++)
                {
                    sb.append(temp);
                }
                
                System.out.println("temp string that build :"+sb.toString());
                
                stack.push(sb.toString());
            }
            else
            {
                System.out.println("push into the stack"+c);
                stack.push(c +"");
            }
        }
        
        String result = "";
        
        while(!stack.isEmpty())
        {
            result = stack.pop() + result;
        }
        
        return result;
    }
    
    private boolean isStringANumber(String input)
    {
        try{
            int num = Integer.parseInt(input);
        }
        catch(Exception e)
        {
            return false;
        }
       
        return true;
    }
}
