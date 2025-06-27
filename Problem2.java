// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

import java.util.Stack;

public class Problem2 {
    public String decodeString(String s) {
        if(s.length() == 0 || s == null || s.length() < 1)
            return s;

        StringBuilder sb = new StringBuilder();

        Stack<Integer> number = new Stack<>();  //for storing numbers
        Stack<String> prefix = new Stack<>();   //for storing prefixes

        //traverse input string
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){          //for digit
                int num = 0;
                while(Character.isDigit(s.charAt(i))){
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;                        //for multi-digit no. and ignoring '['
                }
                number.push(num);
                prefix.push(sb.toString());
                sb.setLength(0);
            }
            else if(ch == ']'){                 //for closing square bracket
                String inner = new String(sb);
                sb.setLength(0);
                sb.append(prefix.pop());
                int n = number.pop();
                for(int k = 0; k < n; k++){
                    sb.append(inner);
                }
            }
            else                                //for alphabets or chars
                sb.append(ch);
        }
        return sb.toString();
    }
}
