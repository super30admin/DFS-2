/**
 * Time Complexity (TC): O(n) - n: The length of the String
 * Space Complexity (SC): O(n)
 */

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> result = new Stack<>();
        StringBuilder current = new StringBuilder();

        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.add(k);
                result.push(current);
                k = 0;
                current = new StringBuilder();
            } else if (ch == ']') {
                int digitremoval = countStack.pop();
                StringBuilder output = result.pop();
                for (int i = 0; i < digitremoval; i++) {
                    output.append(current);
                }
                current = output;
            } else {
                current.append(ch);
            }
        }
        return current.toString();
    }
}
