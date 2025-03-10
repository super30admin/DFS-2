// Time Complexity : O(n) n is the length of the string, traversing the string once.
// Space Complexity : O(n) n is the length of the string, because we are using two stacks.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
import java.util.*;
class Solution {
    public String decodeString(String s) {
        
        Stack<String> strStack = new Stack<>();
        Stack<Integer> digitStack = new Stack<>();
        int digit = 0;
        StringBuilder str = new StringBuilder();
        int index = 0;
        while(index < s.length())
        {
           if(Character.isDigit(s.charAt(index)))
           {
                digit = digit * 10 + s.charAt(index) - '0';
           }
           else if(s.charAt(index) == '[')
           {
                strStack.push(str.toString());
                str.setLength(0);

                digitStack.push(digit);
                digit = 0;
           }
           else if(Character.isLetter(s.charAt(index)))
           {
                str.append(s.charAt(index));
           }
           else if(s.charAt(index) == ']')
           {
                int n = digitStack.pop();
                StringBuilder tres = new StringBuilder();
                for(int i=0; i<n; i++)
                    tres.append(str.toString());
                str.setLength(0);
                str.append(strStack.isEmpty() ? "" : strStack.pop()  + tres.toString());
           }
           index++;
        }
        
        return str.toString();
    }
}