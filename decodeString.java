// Time Complexity : O(n) where n is the length of the string
// Space Complexity : O(n) where n is the length of the string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Stacks

class decodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";
        Stack<Integer> nums = new Stack<>();
        Stack<String> str = new Stack<>();
        int currNum = 0;
        String currStr = "";
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
            }
            else if (c == '[') {
                nums.push(currNum);
                str.push(currStr);
                currNum = 0;
                currStr = "";
            }
            else if (c == ']') {
                StringBuilder sb = new StringBuilder();
                int times = nums.pop();
                for (int i = 0; i < times; i++) {
                    sb.append(currStr);
                }
                currStr = str.pop() + sb;
            }
            else {
                currStr += c;
            }
        }
        return currStr;
    }
}