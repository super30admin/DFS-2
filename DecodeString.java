import java.util.*;

public class DecodeString {
    // TC: O(maxNumber * N) where maxNumber is the maximum number in the string and N is length of string
    // SC: O(M + N) where M is number of characters and N is number of digits
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currString = new StringBuilder();
        int currNum = 0;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (Character.isDigit(currChar)) {
                currNum = currNum * 10 + currChar - '0';
            } else if (currChar == '[') {
                numStack.push(currNum);
                stringStack.push(currString);
                currNum = 0;
                currString = new StringBuilder();
            } else if (currChar == ']') {
                int freq = numStack.pop();
                StringBuilder prevString = stringStack.pop();
                while (freq-- > 0) {
                    prevString.append(currString);
                }
                currString = prevString;
            } else {
                currString.append(currChar);
            }
        }
        return currString.toString();
    }
}
