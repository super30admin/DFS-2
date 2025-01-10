class Solution {
    public String decodeString(String s) {

        // maintain 2 stacks
        // num stacks//string stack which holds the value to be multiplied by num stack
        // At the starting of square bracket push the past strings in string stack and num for future string in num stack
        // At end of square bracket process the past string
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int currNum = 0;
        String currStr = "";
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0'; // calc current numeric value
            } else if (c == '[') {
                numStack.push(currNum);
                strStack.push(currStr);
                currNum = 0;
                currStr = "";
            } else if (c == ']') {
                
                int n = numStack.pop();
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(currStr);
                }
                currStr = strStack.pop();
                currStr += sb.toString();

            } else {
                currStr += c;
            }
        }

        return currStr;

    }
}