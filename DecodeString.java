import java.util.*;
public class DecodeString {
    

    public static String decodeString(String s)
    {
           
        if(s == null || s.length() == 0)
        {
            return s;
        }
        
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        
        int num =0;
        StringBuilder curr = new StringBuilder();
        
        for(int i =0;i<s.length();i++)
        {
            char c = s.charAt(i);
            
            if(Character.isDigit(c))
            {
                num = num*10 + (c-'0'); 
            }
            else if(c=='[')
            {
                numStack.push(num);
                strStack.push(curr);
                num = 0;
                curr = new StringBuilder();
            }
            else if(c==']')
            {
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for(int j=0;j<times;j++)
                {
                    newStr.append(curr);
                }
               curr =  strStack.pop().append(newStr);
            }
            else
            {
                
                curr.append(c);
            }
        }
        
        return curr.toString();
    }
    

    public static void main(String args[])
    {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }
}
