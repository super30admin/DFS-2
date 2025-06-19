import java.util.Stack;

/**
 *  Leetcode 394. Decode String
 *  Link: https://leetcode.com/problems/decode-string/description/
 */
//------------------------------------ Solution 1 -----------------------------------
public class DecodeString {
    /**
     * Iterative solution - As the main logic relies on building result string from the inner most brackets and then
     * to their parent bracket, we will use stacks to store number repeat count before the opening bracket and the string formed
     * by then to respective num and str stacks. Upon encountering a closing bracket we want to repeat the current string by number
     * at the top of the stack and then combining this with the string which is top of string stack(this is parent). And this result string
     * becomes the main current string going forward
     *
     * TC: O(NL) where N -> product of all numerics in worst case and L is the length of the string
     * SC: same as TC since string stack could potentially need to store this long current string
     */
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();

        if (s == null || s.isEmpty()) {
            return sb.toString();
        }

        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        int num = 0;
        int i = 0;

        while (i < s.length()) {
            char c = s.charAt(i);

            if (c == '[') {
                numStack.push(num);
                strStack.push(sb);
                num = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                int repeat = numStack.pop();
                StringBuilder decoded = new StringBuilder();
                for (int j = 0; j < repeat; j++) {
                    decoded.append(sb);
                }
                sb = strStack.pop().append(decoded);;
            } else if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else {
                sb.append(c);
            }
            i++;
        }
        return sb.toString();
    }
}

//------------------------------------ Solution 2 -----------------------------------
class DecodeString2 {
    /**
     * recursive solution - Idea is to recurse when an opening bracket is encountered and result from recursion
     * is repeated num times followed by appending this to the parent string. Recursion terminates open encountering a closing
     * bracket
     * TC is same as previous solution
     * Recursive stack space ax depth will be number of opening/closing brack pairs, and space occupied by the string could be
     * maximum of what was space complexity in previous solution
     */
    int i;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();

        if (s == null || s.isEmpty()) {
            return sb.toString();
        }

        int num = 0;

        while (i < s.length()) {
            char c = s.charAt(i);

            if (c == '[') {
                i++;
                String child = decodeString(s);
                StringBuilder decoded = new StringBuilder();
                for (int j = 0; j < num; j++) {
                    decoded.append(child);
                }
                sb.append(decoded);
                num = 0;
            } else if (c == ']') {
                i++;
                return sb.toString();
            } else if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                i++;
            } else {
                sb.append(c);
                i++;
            }
        }
        return sb.toString();
    }
}