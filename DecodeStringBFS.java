/*
* Approach:
*  1. Use two stack - numStack and strStack
        and currNum and currStr
* 
*  2. Iterate over the string and check if it is digit or character or [ or ]

        if digit, update the currNum by *10 + currDigit.
        if character, append to currStr
        if [, push both currNum and currStr into stack
        if ], pop the numStack and repeat currStr and append to pop of strStack
* 
*  3. For string concatenation, prefer stringbuilder instead of string
        String Builder are mutable, which has shared memory
        String are immutable, which creates new memory every character is attached.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(N)
    N - product of all K's 
* 
* Space Complexity: O(N)
        N - product of all K's 
* 
*/

import java.util.Stack;

public class DecodeStringBFS {
    public String decodeString(String s) {
        Stack<StringBuilder> strStack = new Stack<>();

        Stack<Integer> numStack = new Stack<>();

        int currNum = 0;

        StringBuilder currStr = new StringBuilder();

        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);

            if (Character.isDigit(ch)) {
                currNum = currNum * 10 + (ch - '0');
            } else if (ch == '[') {
                numStack.push(currNum);
                strStack.push(currStr);

                currNum = 0;
                currStr = new StringBuilder();
            } else if (ch == ']') {
                StringBuilder str = new StringBuilder();

                int repetition = numStack.pop();

                for (int j = 0; j < repetition; j++)
                    str.append(currStr);

                str.insert(0, strStack.pop());

                currStr = str;
            } else {
                currStr.append(ch);
            }
        }

        return currStr.toString();
    }
}
