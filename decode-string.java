// TC: o(length od the output string)
// SC: O(Number of brackets)

class Solution {
    public String decodeString(String s) {
        if(s.length() == 0) return "";
        int num = 0;
        StringBuilder currStr = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } else if(ch == '[') {
                numStack.push(num);
                strStack.push(currStr);
                num = 0;
                currStr = new StringBuilder();
            } else if(ch == ']') {
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for(int j=0;j<times;j++) {
                    newStr.append(currStr);
                }
                currStr = strStack.pop().append(newStr);
            } else {
                currStr.append(ch);
            }
        }
        return currStr.toString();
    }
}
