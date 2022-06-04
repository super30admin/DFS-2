// Time Complexity : O(m) or O(k)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        if(s== null || s.length() == 0) return "";
        StringBuilder str = new StringBuilder();
        Stack<StringBuilder> strSt = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        int num = 0;
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                num = (num * 10) + (ch - '0');
            }
            else if(ch == '['){
                strSt.push(str);
                numSt.push(num);
                str = new StringBuilder();
                num = 0;
            }
            else if(ch == ']'){
                int stackNum = numSt.pop();
                StringBuilder childStr = new StringBuilder();
                for(int j =0; j < stackNum; j++){
                    childStr.append(str);
                }
                StringBuilder parent = strSt.pop();
                str = parent.append(childStr);
            }
            else{
                str.append(ch);
            }
        }
        return str.toString();
    }
    
}