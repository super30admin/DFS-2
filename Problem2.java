// Time Complexity : O(maxK x n) where n is the length of the string and K is the maximum number we have to loop
// Space Complexity : O(n) in worst case for stack space where each character goes into stack.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem2 {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;
        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                k = k * 10 + c - '0';
            }else if(c == '['){

                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            }else if(c == ']'){
                StringBuilder decodedString = stringStack.pop();

                for(int currentK = countStack.pop(); currentK > 0; currentK--){

                    decodedString.append(currentString);
                }
                currentString = decodedString;
            }else{
                currentString.append(c);
            }
        }
        return currentString.toString();
    }
}
