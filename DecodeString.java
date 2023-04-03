import java.util.Stack;

//Leetcode - 394
//TC - length of output string
public class DecodeString {

    //Using 2 stacks
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int currNum =0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                currNum = currNum*10 + ch - '0';
            } else if(ch == '[') {
                strSt.push(currStr);
                numSt.push(currNum);
                currStr = new StringBuilder();
                currNum = 0;
            } else if(ch == ']'){
                int count = numSt.pop();
                StringBuilder child = new StringBuilder();
                for(int k=0; k<count; k++) {
                    child.append(currStr);
                }
                StringBuilder parent = strSt.pop();
                currStr = parent.append(child);
            } else {
                currStr.append(ch);
            }
        }
        return currStr.toString();
    }
}
