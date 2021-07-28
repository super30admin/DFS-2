//Time complexity: O(maxDigit*n), where n is the length of the string.
//Space complexity: O(maxDigit*n)

import java.util.*;

class Solution2 {
    public String decodeString(String s) {
        Stack<Integer> digitStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        int num = 0; 
        StringBuilder currentString = new StringBuilder(); 
        for(char c: s.toCharArray()) {
            if(c == '[') {
                // push the number and string to their respective stack
                digitStack.push(num); 
                stringStack.push(currentString);
                // reset the values
                num = 0;
                currentString = new StringBuilder(); 
            } else if(c == ']') {
                StringBuilder newString = new StringBuilder();
                // build the string
                for(int i=digitStack.pop(); i>0; i--) {
                    newString.append(currentString);
                }
                // combine with the parent
                StringBuilder parentString = stringStack.pop();
                parentString.append(newString);
                // update the current string
                currentString = parentString; 
            } else if(Character.isDigit(c)) {
                num = num*10 + (c-'0'); 
            } else {
                currentString.append(c); 
            }
        }
        return currentString.toString(); 
    }
}