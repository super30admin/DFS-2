class Solution {

    /**
     * Open close brackets - stack.
     * 2 stacks needed, NUmber and string. Add number in number stack. Incase 2 digit number (prev *10 +num)
     * Another SB stack. add current string in stack.
     * on closing bracket pop both stack and decode string
     * TC: O(decoded string length)
     * SC: O(decoded string length)
     */
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";

        Stack<StringBuilder> strSt = new Stack();
        Stack<Integer> numSt = new Stack();
        int num = 0;
        StringBuilder currStr = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + Character.getNumericValue(c);
            } else if (c == '[') {
                strSt.push(currStr);
                numSt.push(num);
                currStr = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                StringBuilder currDecode = new StringBuilder();
                int repeat = numSt.pop();
                for (int k = 0; k < repeat; k++) {
                    currDecode.append(currStr);
                }

                StringBuilder parent = strSt.pop();
                currStr = parent.append(currDecode);
            } else {
                //letter
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}
