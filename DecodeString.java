import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        StringBuilder current = new StringBuilder();
        int num = 0;
        java.util.Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();

        if (s == null || s.length() == 0) {
            return "";
        }

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (Character.isDigit(curr)) {
                num = num * 10 + (curr - '0');
            } else if (curr == '[') {
                strStack.add(current);
                numStack.add(num);
                current = new StringBuilder();
                num = 0;

            } else if (curr == ']') {
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for (int j = 0; j < times; j++) {

                    newStr.append(current);
                }
                current = strStack.pop().append(newStr);
            } else {
                current.append(curr);
            }
        }
        return current.toString();
    }
}
