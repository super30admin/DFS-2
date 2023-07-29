// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Process all the characters in the string until "]" is encountered.
 * 2. If "]" is encountered then pop all the characters until "[" is encountered.
 * 3. Pop all the digits and calculate the number.
 * 4. Repeat the string k times and push it back to the stack.
 * 5. Convert the stack to char array and return the string.
 * 6. If the character is not "]" then push it to the stack.
 * 7. Return the string.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ']'){
                List<Character> string = new ArrayList<>();
                while(stack.peek() != '['){
                    string.add(stack.pop());
                }
                stack.pop();

                int k=0, base = 1;
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    k = k + (stack.pop() - '0') * base;
                    base *= 10;
                }

                while(k != 0){
                    for(int j = string.size()-1; j>=0 ; j--){
                        stack.push(string.get(j));
                    }   
                    k--;
                }
            }else {
                stack.push(ch);
            }
        }

        char[] result = new char[stack.size()];
        int i=stack.size()-1;
        while(!stack.isEmpty()){
            result[i--] = stack.pop();
        }

        return new String(result);
    }
}