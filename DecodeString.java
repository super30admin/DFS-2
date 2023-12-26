//T.C O(n)
//S.C O(n)

//Use two stacks to store characters and numbers at the open brackets, at the closing bracket, pop the string
import java.util.Stack;
class DecodeString {
    public String decodeString(String s) {
        Stack<String> charS = new Stack();
        Stack<Integer> numS = new Stack();

        String currStr = "";
        int currNum = 0;
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c))
                currNum = currNum *10 + c- '0';
            else if(c == '['){
                //at start of sq bracket push char to char stack and num to num stack
                numS.push(currNum);
                charS.push(currStr);
                currNum = 0;
                currStr = "";
            } else if(c == ']'){
                //end of sq bracket process the past string from stack
                int times = numS.pop();
                StringBuilder newStr = new StringBuilder();
                for(int j=0;j<times;j++){
                    newStr.append(currStr);
                }
                currStr = charS.pop();
                currStr += newStr;
            } else {
                currStr += c;
            }
        }
        return currStr;
    }


}