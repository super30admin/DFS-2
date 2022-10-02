// TC -
// SC -

import java.util.Stack;

public class DecodeString {

    // Iterative approach
    // TC - O(length of output string)
    // SC - O(number of opening brackets)

    static class Solution1 {
        public String decodeString(String s) {

            Stack<StringBuilder> strSt = new Stack<>();
            Stack<Integer> numSt = new Stack<>();

            StringBuilder currStr = new StringBuilder();
            int num = 0;

            for (int i=0 ; i<s.length(); i++){
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    num = num * 10 + c - '0';
                }
                else if (c == '['){
                    strSt.push(currStr);
                    numSt.push(num);
                    currStr = new StringBuilder();
                    num = 0;
                }
                else if ( c == ']'){
                    int k = numSt.pop();
                    StringBuilder temp = new StringBuilder();
                    for (int j=0; j<k; j++) {
                        temp.append(currStr);
                    }
                    StringBuilder parent = strSt.pop();
                    currStr = parent.append(temp);
                }
                else{
                    currStr.append(c);
                }
            }
            return currStr.toString();
        }
    }

    // Recursive Approach
    // TC - O(n) where n is the length of output string
    // SC - O(b) where b is the number of opening brackets in the input string
    static class Solution2 {
        int i;
        public String decodeString(String s) {

            StringBuilder currStr = new StringBuilder();
            int num = 0;

            while(i<s.length()){
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    num = num * 10 + c - '0';
                    i++;
                }
                else if (c == '['){
                    i++;
                    String decoded = decodeString(s);
                    // parent --> currStr;
                    for(int j=0; j<num; j++) {
                        currStr.append(decoded);
                    }
                    num = 0;
                }
                else if ( c == ']'){
                    i++;
                    return currStr.toString();
                }
                else{
                    currStr.append(c);
                    i++;
                }
            }
            return currStr.toString();
        }
    }

}
