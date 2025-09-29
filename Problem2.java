// Time Complexity : O(kn) where k is the max number in the string and n is the length of the string
// Space Complexity : O(mn) where m is the number of numbers in the stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Using 2 stacks DFS approach where we combine the inner most decoded string with its parent.
class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int currCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                currCount = currCount * 10 + ch - '0';
            } else if (ch == '[') {
                numStack.push(currCount);
                strStack.push(currStr);
                currCount = 0;
                currStr = new StringBuilder();
            } else if (ch == ']') {
                // decoding the string
                StringBuilder decodedBaby = new StringBuilder();
                for (int cnt = numStack.pop(); cnt > 0; cnt--) {
                    decodedBaby.append(currStr);
                }
                // combining with the parent
                currStr = strStack.pop().append(decodedBaby);
            } else {
                // character
                currStr.append(ch);
            }
        }

        return currStr.toString();

    }
}