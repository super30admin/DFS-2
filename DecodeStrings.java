import java.util.Stack;

public class DecodeStrings {

    // TC: O(n) n - length of the output string. Because we will be appending the string to itself based on the number in the input string
    // SC: O(d) d - depth of the opening brace. As long as the opening brace is deeper, we'll be putting the elements into the stack
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return s;

        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();

        int num = 0;
        StringBuilder currentString = new StringBuilder();

        for(int i=0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }else if(c == '['){
                numStack.push(num);
                strStack.push(currentString);

                num = 0;
                currentString = new StringBuilder();
            }else if(c == ']'){
                int times = numStack.pop();
                StringBuilder tempStr = new StringBuilder();
                tempStr.append(String.valueOf(currentString).repeat(Math.max(0, times)));

                currentString = strStack.pop().append(tempStr);
            }else {
                currentString.append(c);
            }
        }

        return currentString.toString();
    }
}
