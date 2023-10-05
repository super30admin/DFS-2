class Solution {
    public String decodeString(String s) {
        
        StringBuilder curStr = new StringBuilder();
        Integer curNum = 0;

        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch))
                curNum = (curNum * 10) + ch - '0';
            else if(ch == '[')
            {
                numStack.push(curNum);
                strStack.push(curStr);
                curNum = 0;
                curStr = new StringBuilder();
            }
            else if(ch == ']'){
                StringBuilder decodedStr = strStack.pop();
                Integer count = numStack.pop();
                while(count-- > 0)
                    decodedStr.append(curStr);
                curStr = decodedStr;
            }
            else
                curStr.append(ch);
        }
        return curStr.toString();
    }
}
