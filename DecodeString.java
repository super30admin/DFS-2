import java.util.Stack;

class Solution {
    /*
        TC - O(n * k), where n is the length of the input and k is the maximum repetition factor
        Sc - O(n)
        This solution uses two stacks to handle nested encoded strings.
        When a digit is encountered, it builds the repeat count. When [ is reached, it saves the current 
        number and string onto the stacks and starts building a new substring. When ] is reached, it pops 
        the repeat count and previous string, repeats the current substring that many times, appends it 
        to the previous string, and continues. This naturally handles nested patterns because the innermost 
        brackets are decoded first.

    */
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = (num * 10) + (ch - '0');
            } else if (ch == '[') {
                numSt.push(num);
                strSt.push(currStr);
                num = 0;
                currStr = new StringBuilder();
            } else if (ch == ']') {
                int n = numSt.pop();
                StringBuilder decoded = new StringBuilder();
                while (n > 0) {
                    decoded.append(currStr);
                    n--;
                }
                StringBuilder parent = strSt.pop();
                currStr = parent.append(decoded);
            } else {
                currStr.append(ch);
            }
        }

        return currStr.toString();
   }
}