// Problem 394. Decode String
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int currNum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + (c - '0');
            } else if (c == '[') {
                numSt.push(currNum);
                strSt.push(currStr);
                currStr = new StringBuilder();
                currNum = 0;
            } else if (c == ']') {
                int cnt = numSt.pop();
                StringBuilder baby = new StringBuilder();
                for (int k = 0; k < cnt; k++) {
                    baby.append(currStr);
                }
                StringBuilder parent = strSt.pop();
                currStr = parent.append(baby);
            } else {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}
