// TC: O(n2)
// SC: O(n)
class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> numsStack = new Stack<>();
        Stack<StringBuilder> stringsStack = new Stack<>();
        int curr_num = 0;
        StringBuilder curr_str = new StringBuilder();
        for(char ch: s.toCharArray()) {
            if(Character.isDigit(ch)) {
                curr_num = curr_num * 10 + (ch - '0');
            } else if(ch == '[') {
                numsStack.push(curr_num);
                stringsStack.push(curr_str);
                curr_num = 0;
                curr_str = new StringBuilder();
            } else if(ch == ']') {
                int num = numsStack.pop();
                StringBuilder str = stringsStack.pop();
                for(int i=0;i<num;i++) {
                    str.append(curr_str);
                }
                curr_str = str;
            } else {
                curr_str.append(ch);
            }
        }
        return curr_str.toString();
    }
}