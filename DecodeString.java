// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> str = new Stack<>();

        int i = 0;
        str.push("");

        while( i < s.length()){
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9'){
                int start = i;
                while(s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9'){
                    i++;
                }
                count.push(Integer.parseInt(s.substring(start, i+1)));
            } else if(ch == '['){
                str.push("");
            } else if(ch == ']'){
                String st = str.pop();
                StringBuilder sb = new StringBuilder();
                int times = count.pop();
                for(int j = 0; j < times; j++){
                    sb.append(st);
                }
                str.push(str.pop() + sb.toString());
            } else {
                str.push(str.pop() + ch);
            }

            i++;
        }
        return str.pop();
    }
}
