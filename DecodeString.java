//TC: O(n)
//SC: O(n)
//approach: using 2 stacks to keep track of current processed string and number of times

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        int count = 0;
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int currNum = 0;
        String currStr = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + c;
            } else if (c == '[') {
                numStack.push(currNum);
                strStack.push(currStr);
                currNum = 0;
                currStr = "";
            } else if (c == ']') {
                int num = numStack.pop();
                StringBuilder str = new StringBuilder();
                for (int j = 0; j<num;j++){
                    str.append(currStr);
                }
                currStr = strStack.pop();
                currStr += str;
            }else {
                currStr += c;
            }
        }
        return currStr;
    }
}