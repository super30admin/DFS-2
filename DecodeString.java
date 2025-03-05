// Approach: Use a global index to traverse the string from start to end. At each index, there are three possible cases: the character can
// be a letter, a closing bracket (]), or a digit. If it's a letter, append it to the final answer string. If it's a closing bracket (]),
// return the final answer formed so far. If it's a digit, collect all consecutive digits until a [ is encountered, convert them to an
// integer (say N), and recursively decode the substring starting after [ by making a recursive call. Append the returned answer to the
// final answer N times. When the global index reaches the end of the string, return the final answer string as the decoded output.
// Time Complexity: O(n) where n - input string length
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// https://leetcode.com/problems/decode-string/description/

// global index to given string
// only process 3 cases in the order: character/letter, ], digit
// encountered [ means start of a new subproblem at next position.

public class DecodeString {
    int index = 0; // global index to given string

    String decodeString(String input) {
        StringBuilder sb = new StringBuilder();

        while (index < input.length()) {
            // only process 3 cases in the order: character/letter, ], digit
            if (Character.isLetter(input.charAt(index))) {
                sb.append(input.charAt(index));
            } else if (input.charAt(index) == ']') {
                return sb.toString();
            } else { // current character is a digit
                StringBuilder num = new StringBuilder();
                while (Character.isDigit(input.charAt(index))) {
                    num.append(input.charAt(index++));
                }
                index++; // skip [ i.e. encountered [ means start of a new subproblem at next position.
                int n = Integer.parseInt(num.toString());
                String sub = decodeString(input);
                while (n-- > 0) {
                    sb.append(sub);
                }
            }
            index++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        // Input: s = "3[a2[c]]"
        // Output: "accaccacc"

        // Input: s = "2[abc]3[cd]ef"
        // Output: "abcabccdcdcdef"
        String input = "3[a2[c]]";
        System.out.println("Decoded string is: " + ds.decodeString(input));
    }
}