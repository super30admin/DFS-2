import java.util.Stack;

/**
 * Time Complexity: O(n) where n is length of string
 * Space Complexity: O(h) 
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * 1. Use two stacks: one to store repeat counts and another to store intermediate string builders.
 * 2. Maintain a result StringBuilder to construct the final decoded string and an integer num to track the current number.
 * Traverse the String:
 * For each character in the input string:
 *       - Digit (ch >= '0' && ch <= '9'): Build the current number by multiplying num by 10 and adding the digit.
 *       - Open Bracket ([):
 *           1. Push num to numStack.
 *           2. Push result to st.
 *           3. Reset num and result.
 *       - Close Bracket (]):
 *           1. Pop the repeat count from numStack.
 *           2. Build the repeated substring by appending result times times.
 *           3. Merge it with the top element of st to continue building the result.
 *       - Characters: Directly append to result.
 */

public class DecodeString {
    public String decodeString(String s) {
        Stack<StringBuilder> st = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int num = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                numStack.push(num);
                st.push(result);
                num = 0;
                result = new StringBuilder();
            } else if (ch == ']') {
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for (int i = 0; i < times; i++) {
                    newStr.append(result);
                }
                StringBuilder str = st.pop();
                result = str.append(newStr);
            } else {
                result.append(ch);
            }

        }
        return result.toString();
    }
    public static void main(String[] args) {
        // Your code here
    }
}