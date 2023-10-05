// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes


// Your code here along with comments explaining your approach: DFS
class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int num = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';

            }
            else if (c == '[') {
                strStack.push(curr);
                numStack.push(num);
                curr = new StringBuilder();
                num = 0;

            }
            else if (c == ']') {
                int time = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for(int j = 0; j < time; j++) {
                    newStr.append(curr);

                }
                curr = strStack.pop().append(newStr);
                

            }
            else {
                curr.append(c);

            }
        }
        return curr.toString();
        
    }
}