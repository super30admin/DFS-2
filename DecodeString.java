import java.util.Stack;

// Time Complexity : O(n) where n is the length of the output string s
// Space Complexity : O(n) for the auxiliary stacks used to store numbers and strings
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Intuition: used 
public class DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int num = 0;
        ;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numSt.push(num);
                strSt.push(currStr);
                num = 0;
                currStr = new StringBuilder();
            } else if (c == ']') {
                int count = numSt.pop();
                StringBuilder decodedStr = new StringBuilder();
                for (int j = 0; j < count; j++) {
                    decodedStr.append(currStr);
                }
                currStr = strSt.pop().append(decodedStr);
            } else {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}
