// Time Complexity: O(n)
// Space Complexity: O(n)
public class DecodeStringRecursion {

    public static String decodeString(String s) {
        return decode(s, 0)[0];
    }

    // Helper function to recursively decode the string starting from index idx
    private static String[] decode(String s, int idx) {
        StringBuilder currentString = new StringBuilder();
        int currentNum = 0;

        // Recursively traverse the string
        while (idx < s.length()) {
            char c = s.charAt(idx);

            // If the character is a digit, we form the number (it could be multi-digit)
            if (Character.isDigit(c)) {
                currentNum = currentNum * 10 + (c - '0');
            }
            // If we encounter a '[', we recursively decode the string inside the brackets
            else if (c == '[') {
                // Recursive call to get the string inside the brackets
                String[] insideBracket = decode(s, idx + 1);
                String insideString = insideBracket[0];
                idx = Integer.parseInt(insideBracket[1]);

                // Repeat the string inside the brackets 'currentNum' times
                for (int i = 0; i < currentNum; i++) {
                    currentString.append(insideString);
                }
                currentNum = 0; // Reset number after using it
            }
            // If we encounter a ']', we return the decoded string and current index
            else if (c == ']') {
                return new String[]{currentString.toString(), String.valueOf(idx + 1)};
            }
            // If it's a regular character, append it to the current string
            else {
                currentString.append(c);
            }
            idx++; // Move to the next character
        }

        return new String[]{currentString.toString(), String.valueOf(idx)};
    }

    public static void main(String[] args) {
        String encoded = "3[a2[c]]";
        System.out.println("Decoded String: " + decodeString(encoded));
    }
}
