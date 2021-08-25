//https://leetcode.com/problems/decode-string/
/*
Time: O(maxNum*n) where n = size of the input string
Space: O(m+n) where m=letters n=digits
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class DecodeString {

    public String decodeString(String s) {

        Stack<StringBuilder> strStack = new Stack();
        Stack<Integer> numStack = new Stack();

        StringBuilder sb = new StringBuilder();
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9')
                num = num * 10 + (c - '0');

            else if (c == '[') // push to both stacks and reset the variables.
            {
                strStack.push(sb);
                sb = new StringBuilder();

                numStack.push(num);
                num = 0; // reset num

            }

            else if (c == ']') {
                int count = numStack.pop();
                StringBuilder currentStr = sb;
                StringBuilder prevStrFromStack = strStack.pop();

                for (int idx = 0; idx < count; idx++)
                    prevStrFromStack.append(currentStr);

                sb = prevStrFromStack; // reset str to the updated value
            }

            else // see a character, store it on str
                sb.append(c);

        }
        return sb.toString();

    }

}
