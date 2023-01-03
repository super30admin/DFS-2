import java.util.*;

public class Decode_String {

    // Approach: Use 2 stacks one for numbers and other for characters
    // Time: O(maxK.n) where maxK = max value of i, n = length of given string
    // Space: O(m + n) where m = no. of nums in num stack, n = no. of stringBuilder objects in str_stack
    public String decodeString(String s) {
        StringBuilder currString = new StringBuilder();
        Stack<Integer> num_stack = new Stack();
        Stack<StringBuilder> str_stack = new Stack();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            }
            else if (ch == '[') {
                num_stack.push(k);
                str_stack.push(currString);
                k = 0;
                currString = new StringBuilder();
            }
            else if (ch == ']') {
                StringBuilder decodedString = str_stack.pop();

                for (int i = num_stack.pop(); i>0; i--) {
                    decodedString.append(currString);
                }
                currString = decodedString;
            }
            else {
                currString.append(ch);
            }
        }
        return currString.toString();
    }
}
