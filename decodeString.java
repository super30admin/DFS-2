// Time Complexity : O(n)  
// Space Complexity: O(n)   
// Did this code successfully run on Leetcode : yes
import java.util.*;
class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        StringBuilder curr = new StringBuilder();
        int num = 0;
        Stack<StringBuilder> str = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
                System.out.println(c);
                System.out.println(num);
            }
            else if(c == '['){
                str.push(curr);
                numSt.push(num);
                curr = new StringBuilder();
                num = 0;
            }
            else if(c == ']'){
                int times = numSt.pop();
                StringBuilder newStr = new StringBuilder();
                for(int j = 0; j < times; j++){
                    newStr.append(curr);
                }
                curr = str.pop().append(newStr);
            }
            else{
                curr.append(c);
            }
        }
        return curr.toString();
    }
}
