// Time complexity - O(n)
// Space complexity - O(n)
// Solved on leetcode - yes
// faced any issues - No
// The solution uses two stacks to decode the string: one for storing repeat counts (numStack) and one for previous strings (strStack). When encountering a '[', it pushes the current context onto the stacks and resets for processing the nested pattern. On encountering ']', it pops from the stacks and appends the repeated substring to build the final result, handling nested and multi-digit patterns correctly.
class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        StringBuilder currentStr = new StringBuilder();
        int currentNum = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNum = currentNum * 10 + (c - '0'); // for multi-digit numbers
            } else if (c == '[') {
                numStack.push(currentNum);
                strStack.push(currentStr.toString());
                currentNum = 0;
                currentStr = new StringBuilder();
            } else if (c == ']') {
                int repeat = numStack.pop();
                String prevStr = strStack.pop();
                StringBuilder temp = new StringBuilder(prevStr);
                for (int i = 0; i < repeat; i++) {
                    temp.append(currentStr);
                }
                currentStr = temp;
            } else {
                currentStr.append(c);
            }
        }

        return currentStr.toString();
    }
}
