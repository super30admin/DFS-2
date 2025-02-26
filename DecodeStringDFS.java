// Time Complexity : O(k + n) where k is product of nestings and n is length of the string
// Space Complexity : O(k + n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// BFS approach with Queue

class DecodeStringDFS {
    int i;
    public String decodeString(String s) {
        int currNum = 0;
        StringBuilder currStr = new StringBuilder();
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                currNum = currNum * 10 + ch - '0';
                i++;
            } else if (ch == '[') {
                i++;
                String decoded = decodeString(s);
                StringBuilder baby = new StringBuilder();
                for (int i = 0; i < currNum; i++) {
                    baby.append(decoded);
                }
                currStr.append(baby);
                currNum = 0;
                i++;
            } else if (ch == ']') {
                return currStr.toString();
            } else {
                currStr.append(ch);
                i++;
            }
        }
        return currStr.toString();
    }
}