import java.util.Stack;
/*
TC -> O(N)
SC -> O(N)
*/



class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int num = 0;
        StringBuilder curr = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> currStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } else if (ch == '[') {
                numStack.push(num);
                currStack.push(new StringBuilder(curr));
                num = 0;
                curr.setLength(0);
            } else if (ch == ']') {
                StringBuilder temp = currStack.pop();
                int times = numStack.pop();
                for (int j = 0; j < times; j++) {
                    temp.append(curr);
                }
                curr = temp;
            } else {
                curr.append(ch);
            }

        }
        return curr.toString();
    }
}