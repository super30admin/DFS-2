
// Time Complexity : The time complexity of the decodeString method is O(n), where n is the length of the input string s. In the worst case, we iterate through each character of the input string once.
// Space Complexity : The space complexity of the decodeString method is O(m), where m is the total number of characters in the decoded string.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: We use two stacks, one to store numbers (numStack) and the other to store strings (strStack). We traverse each character of the input string and perform the decoding process as explained in the problem statement. The decoded string is built iteratively, and the result is returned as the output.
import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(num);
                strStack.push(currentString);
                currentString = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                int repeatTimes = numStack.pop();
                StringBuilder decodedString = strStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(c);
            }
        }

        return currentString.toString();
    }

    public static void main(String[] args) {
        DecodeString decoder = new DecodeString();
        String encodedString = "3[a2[c]]";
        String decodedString = decoder.decodeString(encodedString);
        System.out.println("Decoded String: " + decodedString);
    }
}
