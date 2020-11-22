/**
 * Given an encoded string, return its decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 * 
 * 
 * Space Complexity: O(n)
 * Time Complexity: O(n)
 * 
 * 
 * Leetcode Results:
 * Runtime: 1 ms, faster than 70.11% of Java online submissions for Decode String.
 * Memory Usage: 34.2 MB, less than 100.00% of Java online submissions for Decode String.
 * 
 */
class Solution {
    public String decodeString(String s) {
        // This is a problem of parsing, where we would process something, need to
        // remember something and retrieve what we have already processed.

        Stack<Integer> numStack = new Stack<>(); // count of repetition of following string
        Stack<String> strStack = new Stack<>(); // to save currently processed string, mostly because we encountered '['

        int i = 0, n;
        String current = ""; // to store ongoing processed work

        while (i < s.length()) {

            // if char_i is digit, parse it as it could be multi-digit number
            if (Character.isDigit(s.charAt(i))) {
                n = Integer.parseInt("" + s.charAt(i));
                while (Character.isDigit(s.charAt(i + 1))) {
                    n = n * 10 + Integer.parseInt("" + s.charAt(i + 1));
                    i++;
                }
                numStack.push(n); // save this, would be useful
                i++;
            } else if (s.charAt(i) == '[') {
                // save current to stack, flush current
                strStack.push(current);
                current = "";
                i++;
            } else if (s.charAt(i) == ']') {
                // closing bracket indicates completion of current parse
                // all we need next is to multiply with its correcponding count
                // then concatenate with string previously saved to stack
                String temp = "";
                temp = copyAppend(numStack.pop(), current);
                current = strStack.pop() + temp;
                i++;
            } else {
                // simple case: just concatenate
                current += s.charAt(i);
                i++;
            }
        }
        // all done
        return current;
    }

    // helper that copies s, n times
    private String copyAppend(int n, String s) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            result.append(s);
            n--;
        }
        return result.toString();
    }
}
