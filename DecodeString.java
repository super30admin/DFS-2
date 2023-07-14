import java.util.Stack;

public class DecodeString {

    //Time complexity:O(N) length of the string
    //Space Complexity: O{N)
    public String decodeString(String s) {

        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int currentNumber = 0;

        for(char ch: s.toCharArray()){

            if(Character.isDigit(ch)){
                currentNumber = currentNumber * 10 + (ch - '0');
            }
            else if(ch == '['){
                numStack.push(currentNumber);
                strStack.push(current);
                current = new StringBuilder();
                currentNumber = 0;
            }
            else if(ch == ']'){
                StringBuilder str = strStack.pop();
                int count = numStack.pop();
                for(int i = 0; i < count; i ++){
                    str.append(current);
                }
                current = str;
            }
            else{
                current.append(ch);
            }
        }

        return current.toString();
    }
}
