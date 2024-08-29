// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Build the number k
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                // Push the current number and string onto their stacks
                countStack.push(k);
                stringStack.push(currentString);
                // Reset for the new segment
                currentString = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                // Pop the count and the previous string
                int count = countStack.pop();
                StringBuilder decodedString = stringStack.pop();
                // Append the current string count times to the decoded string
                for (int i = 0; i < count; i++) {
                    decodedString.append(currentString);
                }
                // Set the current string to the decoded string
                currentString = decodedString;
            } else {
                // If it's a character, append it to the current string
                currentString.append(c);
            }
        }

        return currentString.toString();
    }
}
