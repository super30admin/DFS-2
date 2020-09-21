//Time: O(N)
//Space:O(N)
class Solution {
    public String decodeString(String s) {

        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        int currNum = 0;
        String currStr = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                currNum = currNum * 10 + (c - '0');
            } else if (c == '[') {

                // add number found till
                numStack.push(currNum);
                strStack.push(currStr);

                currNum = 0;
                currStr = "";
            } else if (c == ']') {

                int popInt = numStack.pop();
                String temp = "";
                for (int p = 0; p < popInt; p++) {
                    temp += currStr;
                }

                currStr = strStack.pop();
                currStr = currStr + temp;
            } else {
                currStr += c;
            }
        }

        return currStr;
    }
}