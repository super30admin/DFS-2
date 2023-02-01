// Time Complexity : O(L) len of decoded string
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        StringBuilder currentStr = new StringBuilder();
        int currentNumber = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + c - '0';
            } else if (c == '[') {
                strSt.push(currentStr);
                numSt.push(currentNumber);
                currentStr = new StringBuilder();
                currentNumber = 0;
            } else if (c == ']') {
                int count = numSt.pop();
                StringBuilder str = new StringBuilder();
                for (int j = 0; j < count; j++) {
                    str.append(currentStr);
                }
                StringBuilder mainStr = strSt.pop();
                currentStr = mainStr.append(str);
            } else {
                currentStr.append(c);
            }
        }
        return currentStr.toString();
    }
}