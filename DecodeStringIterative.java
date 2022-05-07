// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
import java.util.Stack;

public class DecodeStringIterative {
    public String decodeString(String s) {
        if(s.length() == 0  || s == null){
            return "";
        }

        StringBuilder curString = new StringBuilder();
        int num = 0;

        //2 Stacks
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            //4 Cases
            if(Character.isDigit(c)){ // digit

                num = num * 10 + Character.getNumericValue(c);

            }else if(c == '['){//opening bracket
                numStack.push(num);
                strStack.push(curString);
                num = 0;
                curString = new StringBuilder();

            }else if(c == ']'){// closing bracket
                int times = numStack.pop();

                StringBuilder newStr = new StringBuilder();
                for(int j = 0; j < times; j++){
                    newStr.append(curString);
                }
                curString = strStack.pop().append(newStr);

            }else{// alphabet
                curString.append(c);
            }
        }

        return curString.toString();
    }
}
