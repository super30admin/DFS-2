// Time complexity : O(N)
// Space complexity : O(N)

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        String result = decodeString(s);
        System.out.println(result);
    }

    private static String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        StringBuilder currSt = new StringBuilder();
        int currNum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
            } else if (c == '[') {
                numSt.push(currNum);
                strSt.push(currSt);
                currSt = new StringBuilder();
                currNum = 0;

            } else if (c == ']') {
                int count = numSt.pop();
                StringBuilder newStr = new StringBuilder();
                for (int k = 0; k < count; k++) {
                    newStr.append(currSt);
                }
                StringBuilder parent = strSt.pop();
                currSt = parent.append(newStr);

            } else {
                currSt.append(c);
            }
        }
        return currSt.toString();
    }
}