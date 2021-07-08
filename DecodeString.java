class DecodeString {

    //Time Complexity: O(max k * n) max k is the maximum value of given k
    //Space Complexity: O(m + n) m is the number of letters and n is the nuber of digits

    public String decodeString(String s) {

        if (s == null || s.length() == 0) return s;
        int num = 0;

        StringBuilder currStr = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        for (int i =0; i<s.length(); i++) {

            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c -'0';
            } else if (c == '[') {
                numStack.push(num);
                stringStack.push(currStr);
                num = 0;
                currStr = new StringBuilder();
            } else if (c == ']') {
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for (int k=0; k<times; k++) {
                    newStr.append(currStr);
                }
                StringBuilder parent = stringStack.pop();
                currStr = parent.append(newStr);
            } else {
                currStr.append(c);
            }
        }

        return currStr.toString();

    }

}