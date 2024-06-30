import java.util.Stack;

//Approach - Iterative
//Time - O(n)
//Space - O(n)
class DecodeString {
    public String DecodeString(String s) {
        if(s == null || s.length() == 0) return s;

        StringBuilder curr = new StringBuilder();
        int num = 0;
        Stack<StringBuilder> strStack = new Stack();
        Stack<Integer> numStack = new Stack();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if(Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if(ch == '[') {
                strStack.push(curr);
                numStack.push(num);
                num = 0;
                curr = new StringBuilder();
            } else if(ch == ']') {
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for(int j=0; j<times; j++) {
                    newStr.append(curr);
                }
                curr = strStack.pop().append(newStr);
            } else {
                curr.append(ch);
            }
        }

        return curr.toString();
    }
}