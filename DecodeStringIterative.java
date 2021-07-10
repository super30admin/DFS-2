// Time Complexity : O(m * n) m - max digit, n - max string
// Space Complexity : O(h) h - length of stack

class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0)
            return s;
        int num = 0;
        StringBuilder str = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            else if(c == '['){
                strStack.push(str);
                numStack.push(num);
                str = new StringBuilder();
                num = 0;
            }
            else if(c == ']'){
                StringBuilder tempStr =  new StringBuilder();
                int tempNum = numStack.pop();
                for(int j = 0; j < tempNum; j++)
                    tempStr.append(str);
                StringBuilder parent = strStack.pop();
                str = parent.append(tempStr);
            }
            else{
                str.append(c);
            }
        }
        return str.toString();
    }
}