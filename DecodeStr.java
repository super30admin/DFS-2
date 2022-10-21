// Time Complexity : O(length of the ouput string)
// Space Complexity : O(The depth of the string or the number of open paranthesis)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*
 * Approach 1 - Iterative Solution
 * In this approach, we use two stacks - one stores the curr char and one stores the number in the string. 
 * If digit, assign to the num var. If char, append to the curr StringBuilder. If opening paranthesis, add to the Stack
 * and initialize the digit and curr SB to 0 and "" respectively. When we find the closing paranthesis,
 * decode the string.
 */

import java.util.Stack;

public class DecodeStr {
    public String decodeString(String s) {
        StringBuilder currStr = new StringBuilder();
        int num = 0;
        
        Stack<StringBuilder> str = new Stack<>();
        Stack<Integer> no = new Stack<>();
        
        for(int i = 0; i<s.length();i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
                num = num * 10 + c - '0';
            
            else if(c == '[')
            {
                str.push(currStr);
                no.push(num);
                
                currStr = new StringBuilder();
                num = 0;
            }
            
            else if(c == ']')
            {
                int k = no.pop();
                StringBuilder temp = str.pop();
                for(int j = 0; j < k;j++){
                    temp.append(currStr);
                }
                currStr = temp;
            }
            
            else
            {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}

/*Approach 2 - Recursive solution
 * This is a different type of recursion where we have a global pointer due to which we do not require the 
 * substring functionality. When DecodeString function is called - it retains the value of 'i'.
 */

class Solution {
    int i;
    
    public String decodeString(String s) {
        
        StringBuilder currStr = new StringBuilder();
        int num = 0;
        
        while(i < s.length())
        {
            char c = s.charAt(i);
            
            if(Character.isDigit(c))
            {
                num = num * 10 + c - '0';
                i++;
            }
            
            else if(c == '[')
            {
                i++;
                String decode = decodeString(s);
                for(int j = 0;j < num;j++)
                {
                    currStr.append(decode);
                }
                num = 0;
            }
            
            else if(c == ']')
            {
                i++;
                return currStr.toString();
            }
            else
            {
                i++;
                currStr.append(c);
            }
        }
    return currStr.toString();
    }
}
