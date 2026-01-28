/*
Time Complexity : O(length of string * product of all integers in the encoded string)
Space Complexity : O(length of string * product of all integers in the encoded string)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
Approach :

We should process the innermost encoded string first, so the previous sub string and count should be put on the stack. Once
we found the inner most substring, we should pop the repeat count from the stack and repeat the inner string that many times
and create a child string. Then this child string should be appended to the parent string which is currently on the stack.
Once you update the current string with the child, we can do the same for rest of the children. At the end the current string
would have the resultant decoded string.
*/
import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        StringBuilder currentString = new StringBuilder();
        int currentNumber = 0;
        Stack<Integer> numberStack  = new Stack<>();
        Stack<StringBuilder> stringStack  = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                // Collect all continuous integers together and form a number
                currentNumber = currentNumber*10 + c-'0';
            }else if (Character.isAlphabetic(c)) {
                // collect all continuous letters into a string
                currentString.append(c);
            } else if(c == '['){
                //push both the number and string on their corresponding stacks
                numberStack.push(currentNumber);
                currentNumber = 0;
                stringStack.push(currentString);
                currentString = new StringBuilder();
            }else if(c == ']'){
                // Pop count stack to get repeat count
                Integer repeatCount = numberStack.pop();
                StringBuilder currentChild = new StringBuilder();
                for (int j = 0; j < repeatCount; j++) {
                    //Repeat current string to decode the pattern
                    currentChild.append(currentString);
                }
                StringBuilder currentParent = stringStack.pop();
                // Append the decode string to the parent
                currentString = currentParent.append(currentChild);
            }
        }

        return currentString.toString();
    }
}
