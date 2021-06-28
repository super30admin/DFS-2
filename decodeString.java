package DFS2;

/*
Time Complexity: O(max K * n)
Space Complexity: O(m + n)
*/

import java.util.Stack;

public class decodeString {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return s;

        int num = 0;
        StringBuilder currStr = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();

        for(int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if(c == '[') {
                numStack.push(num);
                strStack.push(currStr);
                num = 0;
                currStr = new StringBuilder();
            } else if(c == ']'){
                int times = numStack.pop();
                StringBuilder newString = new StringBuilder();
                for(int k = 0 ; k < times ; k++) {
                    newString.append(currStr);
                }
                StringBuilder parent = strStack.pop();
                currStr = parent.append(newString);
            } else {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}
