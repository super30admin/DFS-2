/*
Approach: Use a stack of characters to decode patterns like k[encoded_string].
- Push characters until ']' is found. On ']', pop characters to build the encoded substring until '[' is reached.
- Pop digits (which may be multiple digits) to form the repeat count, then push the substring repeated count times back onto the stack.
- Finally, pop remaining characters from the stack to build the result.

Time Complexity: O(n * k) in the worst case where k is the repeat factor (amortized O(n) if repeats are counted toward output size). Each character is pushed/popped a constant number of times relative to the output size.
Space Complexity: O(n) for the stack and temporary lists (proportional to input/output size).

LeetCode: https://leetcode.com/problems/decode-string/
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            if (c == ']') {
                List<Character> list = new ArrayList<>();
                while (stack.peek() != '[') {
                    list.add(stack.pop());
                }
                stack.pop();
                int base = 1;
                int number = 0;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    number = number + ((stack.pop() - '0') * base);
                    base = base * 10;
                }
                while (number != 0) {
                    for (int j = list.size() - 1; j >= 0; j--) {
                        stack.push(list.get(j));
                    }
                    number--;
                }
            } else {
                stack.push(c);
            }
        }

        char[] result = new char[stack.size()];
        for(int i =result.length-1; i>=0; i--){
            result[i] = stack.pop();
        }
        return new String(result);
    }
}
