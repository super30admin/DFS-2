// Time Complexity : O(k * length of result string)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : took some time to understand the code 

// Explain your approach: using 2 stacks, one for number and one for string, 
// for character, add it to current stringbuilder
// for [, add num to num stack and string to string stack
// for num, multiply num by 10 and value to num
// for ], decode string, pop num (say x)from num stack, 
// append curr x times (say newStr) and then append newStr to parent 
import java.util.*;
public class prob2 {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        int num = 0;
        Stack<StringBuilder> str = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        StringBuilder curr = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }else if(c == '['){
                str.push(curr);
                numSt.push(num);
                curr = new StringBuilder();
                num = 0;
            }else if(c == ']'){
                int times = numSt.pop();
                StringBuilder newStr = new StringBuilder();
                for(int k = 0; k < times; k++){
                    newStr.append(curr);
                }
                curr = str.pop().append(newStr);

            }else{
                curr.append(c);
            }
        }
        return curr.toString();
    }
    
}

/* recursion approach


 class Solution {
    int i;
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        StringBuilder curr = new StringBuilder();
        int num = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
                i++;
            }else if(c == '['){
                i++;
                String decoded = decodeString(s);
                StringBuilder newStr = new StringBuilder();
                for(int k = 0; k < num; k++){
                    newStr.append(decoded);
                }
                curr.append(newStr);
                num = 0;
                
            }else if(c == ']'){
                i++;
                return curr.toString();
            }else{
                curr.append(c);
                i++;
            }
        }
        return curr.toString();
    }
}
 */
