//Time o(n)
//space o(n) n length of the string
class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() ==0)
            return "";
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder curStr = new StringBuilder();
        int curNum = 0;
        
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                curNum = curNum*10 + ch - '0';
            }
            else if(ch == '[') {
                numStack.push(curNum);
                strStack.push(curStr);
                curNum = 0;
                curStr = new StringBuilder();
            }
            else if(ch == ']') {
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for(int j=0;j<times;j++) {
                    newStr.append(curStr);
                }
                StringBuilder earlierStr = strStack.pop();
                curStr = earlierStr.append(newStr);
            }
            else {
                curStr.append(ch);
            }
        }
        return curStr.toString();
    }
}