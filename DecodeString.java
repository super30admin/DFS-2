package DFS2;
// Time Complexity : O(k*s) - k is maximum number in string and s is length of string
// Space Complexity : O(no of open brackets)
// Did this code successfully run on Leetcode : Yes

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<StringBuilder> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        StringBuilder prev_str = new StringBuilder();
        int num = 0;
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            if(c == '['){
                s1.push(prev_str);
                s2.push(num);
                num = 0;
                prev_str = new StringBuilder();
            }
            else if(c == ']'){
                int times = s2.pop();
                StringBuilder news = new StringBuilder();
                for(int j=0; j<times; j++){
                    news.append(prev_str);
                }
                prev_str = s1.pop().append(news);
            } else if(Character.isDigit(c)) {
                num = num*10 + (c-'0');
            } else {
                prev_str.append(c);
            }
        }
        return new String(prev_str);
    }

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[a]2[bc]"));
    }
}
