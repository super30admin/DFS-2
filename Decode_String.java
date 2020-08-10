import java.util.Stack;
//Approach:
//1. Here to decode string, I have used two stacks, one for storing the number and the other for storing the string. This numStack stores the number of times the currString has to be processed.
//2. String stack contains all the strings that have been processed before. We will take out the number from numstack and build a string concatenating that many number of times and finally adding up
//with the string from stringStack. 
//3. We keep doing insertion and reset while we get an '[' and if we get a ']', we will do the processing that we mentioned above. 
class Decode_String {
    public String decodeString(String s) {
        StringBuilder currString = new StringBuilder();
        int num = 0;
        if(s == null || s.length() == 0)
        {
            return currString.toString();
        }
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        
        for(int i=0;i< s.length();i++)
        {
            char ch = s.charAt(i);
            if(Character.isDigit(ch))
            {
                num = num *10 + ch - '0';
            }else if(Character.isLetter(ch))
            {
                currString.append(ch);
            }else if(ch == '[')
            {
                numStack.push(num);
                strStack.push(currString);
                num = 0;
                currString = new StringBuilder();
            }else if(ch == ']')
            {
                int times = numStack.pop();
                StringBuilder str = strStack.pop();
                for(int k=0;k< times;k++)
                {
                    str.append(currString);
                }
                currString = str;
            }
        }
        return currString.toString();
    }
}
//Time Complexity : O(n) 
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :