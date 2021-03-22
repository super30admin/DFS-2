import java.util.Stack;

// Time Complexity : O(n); n = len of String
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
public class DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return s;

        Stack<Integer> stackN = new Stack<>();
        Stack<String> stackS = new Stack<>();

        int num = 0;
        String str = "";

        for (int c = 0; c < s.length(); c++) {
            char ch = s.charAt(c);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            else if (ch == '[') {
                stackN.push(num);
                stackS.push(str);
                num = 0;
                str = "";
            }
            else if (ch == ']') {
                int n = stackN.pop();
                String tmp = "";

                for (int i = 0; i < n; i++) {
                    tmp += str;
                }
                str = stackS.pop() + tmp;
            }
            else {
                str += ch;
            }
        }
        return str;
    }
}
