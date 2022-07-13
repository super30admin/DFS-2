// Time Complexity : O(kn)
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Main {
    public static String decodeString(String s) {
        Stack<StringBuilder> sbStk = new Stack<>();
        Stack<Integer> numStk = new Stack<>();

        // current stringbuilder and num
        StringBuilder sb = new StringBuilder();
        int num = 0;

        // traverse in the string
        for (int i = 0; i < s.length(); i++) {
            // character at ith index
            char c = s.charAt(i);
            // check if char is digit
            if (Character.isDigit(c)) {
                // if num then multiply previous num with 10 and then add to current num
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                // if starting bracket then push num and current stringbuilder into stack and
                // reset it
                numStk.push(num);
                sbStk.push(sb);
                sb = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                // if closing bracket pop number from the numStk
                // and get parent stringBuilder from the sbStk and append current stringbuilder
                // k times
                // make currentstringbuilder with temp
                int k = numStk.pop();
                StringBuilder temp = sbStk.pop();
                for (int j = 0; j < k; j++) {
                    temp.append(sb);
                }
                sb = temp;
            } else {
                // if c is letter add this into current stringbuilder
                sb.append(c);
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }
}