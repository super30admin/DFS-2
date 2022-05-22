// tc: o(n) sc: o(D) where D is the depth of the 'tree' of number of nested brackets that exist
class Solution {
    public String decodeString(String s) {
       if(s == null || s.length() == 0) return s;
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int num = 0;
        StringBuilder curString = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            else if(c == '[') {
                numStack.push(num);
                strStack.push(curString);
                num = 0;
                curString = new StringBuilder();
            }
            else if(c ==']') {
               int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for(int j = 0; j < times; j++) {
                    newStr.append(curString);
                }
                curString = strStack.pop().append(newStr);
            }
            else {
                curString.append(c);
            }
        }
        return curString.toString();
    }
}