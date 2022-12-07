
import java.util.*;

//TC is O(len(output string))
//sc is O(levels of nesting)
class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return s;

        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        int num = 0;
        StringBuilder curr = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {

                numStack.push(num);
                strStack.push(curr);
                num = 0;
                curr = new StringBuilder();

            } else if (c == ']') {
                int times = numStack.pop();
                // now we repeat curr string * times
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < times; j++) {
                    sb.append(curr);

                }

                curr = strStack.pop().append(sb);
            } else {
                // c is a string
                curr.append(c);

            }

        }
        return curr.toString();
    }
}