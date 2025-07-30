// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";

        StringBuilder currStr = new StringBuilder();
        int currNum = 0;

        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                // number
                currNum = currNum*10 + (c-'0');
            } else if (c == '[') {
                // push stack
                numStack.push(currNum);
                strStack.push(currStr);
                currNum = 0;
                currStr = new StringBuilder();
            } else if (c == ']') {
                // pop stack
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for (int j=0; j<times; j++) {
                    newStr.append(currStr);
                }
                currStr = strStack.pop().append(newStr);
            } else {
                // alphabet
                currStr.append(c);
            }
        }

        return currStr.toString();
    }
}
