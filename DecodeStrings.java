import java.util.Stack; 

// Time Complexity: O(n), where n is the length of the input string.
// Space Complexity: O(n), for the stacks used to store strings and numbers.
// LeetCode: https://leetcode.com/problems/decode-string/

/**
 * Decodes an encoded string where patterns like k[encoded_string] are repeated k times.
 * Uses two stacks to track multipliers and intermediate strings during traversal.
 * Returns the fully decoded string after processing the entire input.
 */

public class DecodeStrings {
    public String decodeString(String s) {
        Stack<StringBuilder> stringStk = new Stack<>();
        Stack<Integer> numStk = new Stack<>();
        int k = 0;
        StringBuilder currentString = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = (k * 10) + (c - '0');
            }

            else if (c == '[') {
                numStk.push(k);
                stringStk.push(currentString);
                k=0;
                currentString = new StringBuilder();
            }

            else if (c == ']') {
                StringBuilder decodedString = stringStk.pop();
                for (int currentK = numStk.pop(); currentK > 0; currentK--) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(c);
            }
        }
        
        return currentString.toString();
    }
}
