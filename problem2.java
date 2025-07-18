// Time Complexity : O(n), where n is the length of the input string.
// Space Complexity : O(n) for the stack used to store numbers and strings.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I used two stacks, one for numbers and one for strings. I iterate through the string character by character. If I encounter a digit, I build the number. If I encounter '[', I push the current number and string onto their respective stacks and reset them. If I encounter ']', I pop from both stacks and repeat the current string as many times as specified by the popped number. If it's a regular character, I append it to the current string.

class Solution {
    public String decodeString(String s) {
        Stack<Integer> stackNum = new Stack<>();
        Stack<StringBuilder> stackChars = new Stack<>();
        StringBuilder currentStr = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) k = k * 10 + (ch - '0');
            else if (ch == '[') {
                stackNum.push(k);
                stackChars.push(currentStr);
                k = 0;
                currentStr = new StringBuilder();
            } else if (ch == ']') {
                int repeatTimes = stackNum.pop();
                StringBuilder previousStr = stackChars.pop();
                for (int i = 0; i < repeatTimes; i++) previousStr.append(currentStr);
                currentStr = previousStr;
            } else currentStr.append(ch);
        }
        return currentStr.toString();
    }
}
