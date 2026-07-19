// Time Complexity :  O(n) where n is the length of the input string s
// Space Complexity : O(n) where n is the length of the input string s, in the worst case we can have all characters in the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
// Approach :
// 1. We will use two stacks, one for storing the numbers and another for storing the strings.
// 2. We will traverse the input string and whenever we encounter a digit, we will calculate the current number.
// 3. When we encounter a '[', we will push the current number and the current string to their respective stacks and reset them.
// 4. When we encounter a ']', we will pop the number from the numStack and the string from the strStack,
//  and we will append the current string to the parent string count times.
//  5. Finally, we will return the current string as the result after traversing the entire input string.

import java.util.*;

class Solution {

    public String decodeString(String s) {

        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();

        int currNum = 0;

        StringBuilder currString = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (Character.isDigit(c)) {

                currNum = currNum * 10 + (c - '0');

            } else if (c == '[') {

                numStack.push(currNum);
                strStack.push(currString);

                currNum = 0;
                currString = new StringBuilder();

            } else if (c == ']') {

                int count = numStack.pop();

                StringBuilder parent = strStack.pop();

                for (int k = 0; k < count; k++) {
                    parent.append(currString);
                }

                currString = parent;

            } else {

                currString.append(c);
            }
        }

        return currString.toString();
    }
}