// Time Complexity O(n)
// Space Complexity O(n)
// Runs on LeetCode YES

class Solution {
    public String decodeString(String s) {
        int num = 0;
        StringBuilder currString = new StringBuilder();

        Stack<Integer> numSt = new Stack<Integer>();
        Stack<StringBuilder> strSt = new Stack<StringBuilder>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '[') {
                numSt.push(num);
                strSt.push(currString);
                num = 0;
                currString = new StringBuilder();

            } else if (ch == ']') {
                int count = numSt.pop();
                StringBuilder sb = new StringBuilder();

                for(int j=0; j< count; j++){
                    sb.append(currString);
                }
                currString = strSt.pop().append(sb);

            } else if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } else {
                currString.append(ch);
            }
        }
        return currString.toString();
    }
}