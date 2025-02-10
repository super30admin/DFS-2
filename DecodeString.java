
/**
 * Time Complexity: O(n) where n is length of string
 * Space Complexity: O(n)
 */

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int num = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                numStack.push(num);
                strStack.push(result);
                num = 0;
                result = new StringBuilder();
            } else if (ch == ']') {
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for (int i = 0; i < times; i++) {
                    newStr.append(result);
                }
                StringBuilder str = strStack.pop();
                result = str.append(newStr);
            } else {
                result.append(ch);
            }

        }
        return result.toString();
    }
}
