// Time Complexity : O(num*n) num - maximum number that is generated and n is length of the string
// Space Complexity : O(m+n) m - number of letter & n - number of digits.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        
        if(s.length() == 1) return s;
        
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        
        StringBuilder currStr = new StringBuilder();
        int num = 0;

        // Iterate over all the characters in the input string.
        for(char ch: s.toCharArray()){
            
            if(Character.isDigit(ch)){
                // If the current character is a digit, then create a number out of that digit.
                num = (num*10)+(ch - '0');
            }else if(ch == '['){
                // If the character is [, then push the current number and the string into their respective stacks.
                numStack.push(num);
                strStack.push(currStr);
                // reset the current number and string to initial values.
                num = 0;
                currStr = new StringBuilder();
            }else if(ch == ']'){
                // If the character is ], then pop the parent number and the accumulated parent string.
                int count = numStack.pop();

                // Generating the new string in combination with the parent number.
                StringBuilder temp = new StringBuilder();
                for(int i = 0; i < count; i++){
                    temp = temp.append(currStr);
                }

                // Combine the parent string with the newly generated temporary string.
                // Assign the combined value as the current string.
                currStr = strStack.pop().append(temp);
            }else{
                // If the current character is letter, then append it to the current string.
                currStr.append(ch);
            }
        }
        return currStr.toString();
    }
    
}
