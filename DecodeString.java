import java.util.Stack;

/* 
## Problem2: (https://leetcode.com/problems/decode-string/)
 
Time Complexity :   O (length of output string) 
Space Complexity :  O (no. of perning brackets) 
Did this code successfully run on Leetcode :    Yes (394. Decode String)
Any problem you faced while coding this :       No
 */

// Input: s = "3[a]2[bc]"
// Output: "aaabcbc"

class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k=0;
        
        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                k = k * 10 + c - '0';
            }
            else if(c == '['){
                countStack.push(k);
                stringStack.push(currentString);
                
                // reset to default
                currentString = new StringBuilder();
                k=0;
            }
            // decode string
            else if(c == ']'){
                StringBuilder decoded = stringStack.pop();
                int count = countStack.pop();
                while(count > 0){
                    decoded.append(currentString);
                    count--;
                }
                currentString = decoded;
            }
            else{
                currentString.append(c);
            }
        }
        return currentString.toString();
    }
}