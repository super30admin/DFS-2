import java.util.Stack;

// Time Complexity : O(NK) : k = biggest number in the input string
// Space Complexity : O(NK) : k = biggest number in the input string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// We maintain stack of the curr string in form of stringBuilder
// We iterate over the char of string one by one
// When we encounter number we update our "times" variable
// When we encounter character we append it to our sb
// When we encounter open bracket '[' we push "times" and currStr into stacks & reset them for inner sub problem
// When we encounter closing bracket ']' we generate new String based on times and curr String and append to current Str
class DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return s;

        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int times = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                // dump curr str into str stack
                strStack.push(sb.toString());
                sb.setLength(0);
                // dump into numStack
                numStack.push(times);
                times = 0;
            } else if (c == ']') {
                String newStr = generateTimesString(sb.toString(), numStack.pop());
                sb.setLength(0);
                sb.append(strStack.pop());
                sb.append(newStr);
            } else {
                if (Character.isDigit(c)) {
                    times = times * 10 + Character.getNumericValue(c);
                } else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    private String generateTimesString(String childStr, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(childStr);
        }
        return sb.toString();
    }
}