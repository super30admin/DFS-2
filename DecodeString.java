// Time Complexity: O(n) n is length of input string and we process each character once and in worst case every character is added and removed from stack atmost once
// Space Complexity: O(n) worst case we store all characters in a stack , leading to space cpmplexity proportional to the length of input

import java.util.Stack;

public class DecodeString {

    public static String decodeString(String s) {
        // Stack to store the number and the current decoded string
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int currentNum = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If it's a digit, form the number (it could have more than one digit)
            if (Character.isDigit(c)) {
                currentNum = currentNum * 10 + (c - '0');
            }
            // If it's '[', push the current number and string onto the stacks
            else if (c == '[') {
                numStack.push(currentNum);
                strStack.push(currentString.toString());
                currentString = new StringBuilder(); // reset current string for the new part
                currentNum = 0; // reset current number
            }
            // If it's ']', pop from the stacks and build the string
            else if (c == ']') {
                int repeatTimes = numStack.pop();
                StringBuilder decodedPart = new StringBuilder();
                for (int j = 0; j < repeatTimes; j++) {
                    decodedPart.append(currentString);
                }
                currentString = new StringBuilder(strStack.pop()).append(decodedPart);
            }
            // If it's a character, add it to the current string
            else {
                currentString.append(c);
            }
        }

        return currentString.toString();
    }

    public static void main(String[] args) {
        String encoded = "3[a2[c]]";
        System.out.println("Decoded String: " + decodeString(encoded));
    }
}
