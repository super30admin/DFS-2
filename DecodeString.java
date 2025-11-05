// Time Complexity : O(n*k) where n is the length of the string and k is the maximum repeat count
// Space Complexity : O(n*k)
// Did this code successfully run on Leetcode : Yes
// Approach : We maintain two stacks, one for storing numbers and one for parent String(the string that has been built until we came
// across ']'. If we come across a number we store it and continue parsing. If we come across character we append to the existing character
// If we come across '[' we push the number and currently built string to respective stacks. If we come across ']' , we pop the number and
// loop it with the current string and append to the parent string and continue the process.

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();

        int currNum = 0;
        StringBuilder currStr = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0'; //compute the number
            }
            else if (c == '[') {
                strStack.push(currStr);
                numStack.push(currNum);
                currNum = 0; //reset to 0
                currStr = new StringBuilder(); //reset to empty String

            }
            else if (c == ']') {
                int count = numStack.pop();
                StringBuilder parent = strStack.pop();

                for (int j = 0; j < count; j++) { //construct the inner string
                    parent.append(currStr);
                }

                currStr = parent;
            }
            else { //when character is encountered
                currStr.append(c);
            }
        }

        return currStr.toString();
    }
}
