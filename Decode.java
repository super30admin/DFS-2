import java.util.Stack;

public class Decode {
    // Time Complexity: O(maxK⋅n), where maxK is the maximum value of k and n is the
    // length of a given string s.
    // Space Complexity: O(m+n), where m is the number of
    // letters(a-z) and n is the number of digits(0-9) in string s.
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Stack<StringBuilder> str = new Stack<>();
        Stack<Integer> in = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                str.push(curr);
                in.push(num);
                num = 0;
                curr = new StringBuilder();
            } else if (c == ']') {
                int nu = in.pop();
                StringBuilder child = new StringBuilder();
                for (int k = 0; k < nu; k++) {
                    child.append(curr);
                }
                StringBuilder parent = str.pop();
                curr = parent.append(child);
            } else {
                curr.append(c);
            }
        }
        return curr.toString();
    }
}
