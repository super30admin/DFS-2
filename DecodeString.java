import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> charStack = new Stack<>();
        int curNum =0;
        String curStr = "";
        
        for(int i=0; i < s.length(); i++){
            
            // char c = s.charAt(i);
            if(Character.isDigit(s.charAt(i))){
                curNum = curNum *10 + s.charAt(i) - '0';
            }else if(s.charAt(i) == '['){
                numStack.push(curNum);
                charStack.push(curStr);
                curNum = 0;
                curStr = "";
            }else if(s.charAt(i)== ']'){
                int numOftimes = numStack.pop();
                StringBuilder sb = new StringBuilder();
                for(int j =0 ; j < numOftimes ; j++){
                    sb.append(curStr);
                }
                curStr = charStack.pop();
                curStr = curStr +sb ;
            }else {
                curStr += s.charAt(i);
            }
        }
        return curStr;
    }
}