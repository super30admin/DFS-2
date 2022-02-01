// Time Complexity : O(size of decoded string)
// Space Complexity : O(length of string)
// Did this code successfully run on Leetcode : Yes

import java.util.*;

public class DecodeString {
    //  Iterative Solution

    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return "";

        Stack<StringBuilder> ss = new Stack<>();
        Stack<Integer> cs = new Stack<>();

        StringBuilder curString = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); ++i) {

            char c = s.charAt(i);

            //  digit
            if (Character.isDigit(c)) {
                count = count*10 + c - '0';
            }

            //  [
            else if (c == '[') {
                cs.push(count);
                ss.push(curString);
                count = 0;
                curString = new StringBuilder();
            }

            //  ]
            else if (c == ']') {
                //  decipher the current string according to its repeat count
                int rep = cs.pop();
                StringBuilder childString = new StringBuilder();
                for (int j = 0; j < rep; ++j) {
                    childString.append(curString);
                }

                //  combine with parent
                StringBuilder parentString = ss.pop();
                curString = parentString.append(childString);
            }

            //  alphabet
            else {
                curString.append(c);
            }
        }

        return curString.toString();
    }
}
