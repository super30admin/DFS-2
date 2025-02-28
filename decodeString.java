// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    int i;

    public String decodeString(String s) {
        int num = 0;
        StringBuilder currStr = new StringBuilder();
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
                i++;
            } else if (c == '[') {
                i++;
                String baby = decodeString(s);
                for (int k = 0; k < num; k++) {
                    currStr.append(baby);
                }
                num = 0;
            } else if (c == ']') {
                i++;
                return currStr.toString();
            } else {
                currStr.append(c);
                i++;
            }
        }
        return currStr.toString();
    }

}
