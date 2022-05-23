import java.util.Stack;

// O(maxK n) time, maxK is max value of k and n is length of given string: overall we traverse string of size n and iterate it k times to decode pattern of form k[string]
// O(m + n) space, m is number of letters and n is number of digits in string, since max values of countStack and stringStack, respectively

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()){
            // case 1: current character is digit, append to k
            if (Character.isDigit(ch)){
                k = k * 10 + ch - '0';
            }
            
            // case 2: opening bracket, push k into countStack and currentString into stringStack
            else if (ch == '['){
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder(); // reset currentString
                k = 0; // reset k
            }
            
            // case 3: closing bracket --> begin decoding process
            else if (ch == ']'){
                // pop decodedString that contains previously decoded string
                StringBuilder decodedString = stringStack.pop();
                // decode currentString - pop current from countStack and decode pattern
                for (int current = countStack.pop(); current > 0; current--){
                    decodedString.append(currentString);
                }
                currentString = decodedString; // update currentString
            }
            
            // case 4: letter, append to currentString
            else{
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }
}