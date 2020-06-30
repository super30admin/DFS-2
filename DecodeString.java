/**
 * Time Complexity : O(N) 
 * Space Complexity : O(N) 
 * Here we will be using two stacks, one for string and other for number
 * For types of input can be there (Number , [ , character , ])
 * Depending upon the input, we will manipulate 2 stacks and achieve the desired result
 */

import java.util.Stack;
public class DecodeString {
    public String decodeString(String s) {
        Stack<String> result = new Stack<>();
        Stack<Integer> count = new Stack<>();
        int index = 0;
        String res = "";
        while(index<s.length())
        {
            char curr = s.charAt(index);
            if(Character.isDigit(curr))
            {
                int number = 0;
                while(Character.isDigit(s.charAt(index)))
                {
                    number = number * 10 + s.charAt(index) - '0';
                    index++;
                }
                count.push(number);
            }
            else if(curr == '[')
            {
                result.push(res);
                res = "";
                index++;
            }
            else if(curr == ']')
            {
                StringBuilder sb = new StringBuilder(result.pop());
                int currNumber = count.pop();
                for(int i = 0 ; i < currNumber ; i ++)
                {
                    sb.append(res);
                }
                res  = sb.toString();
                index ++;
            }
            else
            {
                res = res + s.charAt(index);
                index++;
            }
        }
        return res;
    }
}