
// Time Complexity : O(N)
// Space Complexity :O(N) N = length of the string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//1. Keep track of the 'k' value or the number of time the string is expected to repeat in a stak.
//2. The character value could be tracked in another stack.
//3. Each character of the string is checked and evaluated accordingly.
import java.util.*;

class DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return "";

        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        int curNum = 0;
        String curStr = "";

        for (int x = 0; x < s.length(); x++) {
            char ch = s.charAt(x);

            if (Character.isDigit(ch)) {
                curNum = curNum * 10 + (ch - '0');
            } else if (ch == '[') {
                numStack.add(curNum);
                strStack.add(curStr);

                curNum = 0;
                curStr = "";

            } else if (ch == ']') {
                int popNum = numStack.pop();
                String temp = "";
                for (int i = 0; i < popNum; i++)
                    temp += curStr;
                curStr = strStack.pop();
                curStr = curStr + temp;

            } else {
                curStr += ch;
            }
        }
        return curStr;
    }

    public static void main(String args[]) {
        DecodeString obj = new DecodeString();
        String str = "4[a1[b]]";
        System.out.println(obj.decodeString(str));
    }
}