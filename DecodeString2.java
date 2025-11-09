/*
Approach: Use two stacks — one for repeat counts and one for partial strings.
- Parse the input: accumulate digits to form numbers, push number and current string on encountering '[' and reset them.
- On ']', pop the repeat count and previous string, append the current built string repeated count times to the previous string.
- Continue until the entire string is processed.

Time Complexity: O(n * k) where k is the repeat factor; amortized O(n) if repeats are accounted for in output size.
Space Complexity: O(n) for the stacks and string builders (proportional to input/output size).

LeetCode: https://leetcode.com/problems/decode-string/
*/
import java.util.Stack;

public class DecodeString2 {

    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        int num = 0;
        StringBuilder currentString = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                numStack.push(num);
                stringStack.push(currentString);
                num = 0;
                currentString = new StringBuilder();

            } else if (c == ']') {
                int number = numStack.pop();
                StringBuilder parent = stringStack.pop();
                while (number > 0) {
                    parent.append(currentString);
                    number--;
                }
                currentString = parent;
            } else {
                currentString.append(c);
            }
        }
        return currentString.toString();
    }

    public static void main(String[] args) {
        System.out.println(new DecodeString2().decodeString("z3[a]2[bc]"));
    }
}
