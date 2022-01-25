// Time Complexity : O(n), n - length of string
// Space Complexity : O(m), m - length of deciphered String
// Did this code successfully run on Leetcode : Yes

import java.util.Stack;

public class Decode_String {

    public String decodeString(String s) {

        if(s == null || s.length() == 0) return s;

        Stack<StringBuilder> parentSt = new Stack<>();
        Stack<Integer> mFactorSt = new Stack<>();
        int multiplicationFactor = 0;
        StringBuilder curr = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            //digit
            if(Character.isDigit(c)){
                multiplicationFactor = multiplicationFactor * 10 + (c - '0');
            }
            //[
            else if(c == '['){
                mFactorSt.push(multiplicationFactor);
                parentSt.push(curr);
                multiplicationFactor = 0;
                curr = new StringBuilder();
            }
            //]
            else if(c == ']'){
                //decipher the curr String
                int MFactor = mFactorSt.pop();
                StringBuilder deciphered = new StringBuilder();
                for(int k = 0; k < MFactor; k++){
                    deciphered.append(curr);
                }
                //combine with parent
                StringBuilder parent = parentSt.pop();
                parent.append(deciphered);
                curr = parent;
            }
            //char
            else{
                curr.append(c);
            }
        }
        return curr.toString();
    }

    public static void main(String[] args) {
        System.out.println("Decoded String : " + new Decode_String().decodeString("3[a]2[bc]"));
    }
}
