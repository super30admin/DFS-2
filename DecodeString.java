// Time Complexity : O(kn) or O(length of output string)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, had to learn.

/*
 * Problem#394
 * 
 * Stack - DFS - Inner most child -> means we can also do it recursively
 * 
 * Stack is a DS.
 * 
 * 4 scenarios: character, number , [ , ]
 * 
 * if [ -> add currNum and currString to Stack and reset the currNum & currString
 * if ] -> pop the number and iterate number times and append currentString to parent
 */

import java.util.*;

public class DecodeString {

    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        int currNum = 0;
        StringBuilder currString = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                // if its a number
                currNum = currNum * 10 + c - '0';
            } else if (c == '[') {
                numStack.push(currNum);
                stringStack.push(currString);
                currNum = 0;
                currString = new StringBuilder();

            } else if (c == ']') {
                int temp = numStack.pop();
                StringBuilder parent = stringStack.pop();
                for (int k = 0; k < temp; k++) {
                    parent.append(currString.toString());
                }

                currString = parent;

            } else {
                // if its a character
                currString.append(c);
            }
        }

        return currString.toString();

    }
}