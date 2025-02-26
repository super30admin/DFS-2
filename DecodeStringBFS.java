// Time Complexity : O(k + n) where k is product of nestings and n is length of the string
// Space Complexity : O(k + n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// BFS approach with Queue

class DecodeStringBFS {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> st = new Stack<>();
        int currNum = 0;
        StringBuilder currStr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                currNum = currNum * 10 + ch - '0';
            } else if (ch == '[') {
                numSt.push(currNum);
                st.push(currStr);
                currNum = 0;
                currStr = new StringBuilder();
            } else if (ch == ']') {
                int count = numSt.pop();
                StringBuilder baby = new StringBuilder();
                for (int k = 0; k < count; k++) {
                    baby.append(currStr);
                }
                StringBuilder parentStr = st.pop();
                currStr = parentStr.append(baby);
            } else {
                currStr.append(ch);
            }
        }
        return currStr.toString();
    }
}