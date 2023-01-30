// Time Complexity : O(L) len of decoded string
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int currNum = 0;git a
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
            } else if (c == '[') {
                strSt.push(currStr);
                numSt.push(currNum);
                currStr = new StringBuilder();
                currNum = 0;
            } else if (c == ']') {
                int count = numSt.pop();
                StringBuilder str = new StringBuilder();
                for (int j = 0; j < count; j++) {
                    str.append(currStr);
                }
                StringBuilder mainStr = strSt.pop();
                currStr = mainStr.append(str);
            } else {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}