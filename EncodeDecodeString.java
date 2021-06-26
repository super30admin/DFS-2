// Time Complexity : O(max(k)*max( string)
// Space Complexity : max string in stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package dfs2;

import java.util.*;

public class EncodeDecodeString {

    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int num = 0;
        StringBuilder currS = new StringBuilder();
        Stack<StringBuilder> strS = new Stack<>();
        Stack<Integer> numS = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                numS.push(num);
                strS.push(currS);
                num = 0;
                currS = new StringBuilder();
            } else if (c == ']') {
                int times = numS.pop();
                StringBuilder newS = new StringBuilder();
                for (int k = 0; k < times; k++) {
                    newS.append(currS);
                }
                StringBuilder parent = strS.pop();
                currS = parent.append(newS);
            } else {
                currS.append(c);
            }
        }
        return currS.toString();
    }
}
