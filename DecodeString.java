// Time Complexity : O(Max(num) * length of String)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach DFS

// Made use of two stacks, one for digits and the other for string
// whenever we see digit we put in num 
// and when we see char we append to str
// when we see [ we put them onto the stacks
// when we see ] we take the num from the stack and append the str num times
// then we append this to whatever is there on the top of the stack
class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return "";
        Stack<StringBuilder> strS = new Stack<>();
        Stack<Integer> numS = new Stack<>();
        int num = 0;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                strS.push(str);
                numS.push(num);
                num = 0;
                str = new StringBuilder();
            } else if (c == ']') {
                int times = numS.pop();
                StringBuilder newStr = new StringBuilder();
                for (int j = 0; j < times; j++) {
                    newStr.append(str);
                }
                str = strS.pop().append(newStr);
            } else {
                str.append(c);
            }
        }
        return str.toString();
    }
}