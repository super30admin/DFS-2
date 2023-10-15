/* 

## Problem2 (https://leetcode.com/problems/decode-string/)

Time Complexity : O(m)
Space Complexity : O(m)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

*/

class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int num = 0;

        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            else if(c == '['){
                numStack.push(num);
                stringStack.push(curr);
                num = 0;
                curr = new StringBuilder();
            }
            else if( c == ']'){
                int times = numStack.pop();
                StringBuilder temp = new StringBuilder();
                for(int j = 0; j< times; j++){
                    temp.append(curr);
                }
                curr = stringStack.pop().append(temp); 
            }
            else{
                curr = curr.append(c);
            }

        }

        return curr.toString();

    }
}

