// Time Complexity : O(L), length of decoded string
// Space Complexity : O(m + n), m - size of string stack and n - size of freq stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : it was difficult to dry run and code without bugs initially
// Approach:
// 1. Use 2 stacks, one to store char and other to store the digit
// 2. Iterate over the input string
//  - if char is alphabet, append to string variable
//  - if char is digit, store it in freq variable
//  - if char is [, push the string and freq to corresponding stacks and initialize the string and freq vars
//  - if char is ], pop from 2 stacks, popped string + append the current string freq times will be the current string
// 3. Return current string

import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<String> charStk = new Stack<>();
        Stack<Integer> countStk = new Stack<>();

        StringBuilder curStr = new StringBuilder();
        int freq = 0;

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if(Character.isDigit(ch)) {
                freq = (freq * 10) + (ch - '0');
            }
            else if(Character.isLetter(ch)) {
                curStr.append(ch);
            }
            else if(ch == '[') {
                charStk.push(curStr.toString());
                curStr = new StringBuilder();

                countStk.push(freq);
                freq = 0;
            }
            else {
                // closing bracket
                String str = charStk.pop();
                int c = countStk.pop();

                StringBuilder tmp = new StringBuilder();
                if(!str.equals("")) {
                    tmp.append(str);
                }
                for(int j=0; j<c; j++) {
                    tmp.append(curStr);
                }
                curStr = tmp;
            }
        }
        return curStr.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }
}
