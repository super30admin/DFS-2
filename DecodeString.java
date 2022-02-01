class Solution {
    // Time Complexity : O(l), where l is the length of the decoded string
    // Space Complexity : O(m), where m is the length of the input string
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    public String decodeString(String s) {
        if(s == null || s.length() == 0)
            return null;

        Stack<Integer> numSt = new Stack<Integer>();
        Stack<StringBuilder> strSt = new Stack<StringBuilder>();
        int num = 0;
        StringBuilder curr = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(Character.isDigit(ch)) {
                num = num*10 + ch-'0';
            } else if(ch == '[') {
                numSt.push(num);
                strSt.push(curr);
                num = 0;
                curr = new StringBuilder();
            } else if(ch == ']') {
                int count = numSt.pop();
                StringBuilder temp = new StringBuilder();
                for(int k = 0; k < count; k++) {
                    temp = temp.append(curr);
                }
                StringBuilder parent = strSt.pop();
                curr = parent.append(temp);
            } else {
                curr = curr.append(ch);
            }
        }
        return curr.toString();
    }
}