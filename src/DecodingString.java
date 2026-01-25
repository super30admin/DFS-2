import java.util.Stack;

/*
LeetCode 394. Decode String
*/
public class DecodingString {

    /*
     APPROACH 1: Iterative (Two Stacks)
     Idea:
     - Use one stack for repeat counts (numbers).
     - Use another stack for previously built strings (parent strings).
     - Walk through the string:
       - If digit: build currNum (handle multi-digit)
       - If '[': push currNum and current string onto stacks, reset both for inner block
       - If ']': pop repeat count and parent string, append current block repeated, merge back to parent

     Time Complexity: O(n * expansion)
       - n is input length, but output can be larger due to repeats
     Space Complexity: O(n)
       - stacks + output building
     */
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();

        int currNum = 0;
        StringBuilder currString = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                // build multi-digit number: "12[a]" => 12
                currNum = currNum * 10 + (c - '0');
            } else if (c == '[') {
                // entering a nested encoded block:
                // save current context (parent string + repeat count)
                strStack.push(currString);
                countStack.push(currNum);

                // reset for decoding inside brackets
                currNum = 0;
                currString = new StringBuilder();
            } else if (c == ']') {
                // finished decoding the current bracket content
                int cnt = countStack.pop();
                StringBuilder parent = strStack.pop();

                // append currString repeated cnt times to parent
                for (int k = 0; k < cnt; k++) {
                    parent.append(currString);
                }

                // the parent becomes the current string now
                currString = parent;
            } else {
                // normal character, add to current decoded segment
                currString.append(c);
            }
        }

        return currString.toString();
    }

    // Pointer used by recursion approach
    private int idx = 0;

    /*
     APPROACH 2: Recursion (DFS with an index pointer)
     Idea:
     - Use a shared index idx that walks through the string once.
     - Each recursive call decodes until it hits a closing bracket ']'
       (or end of string).
     - When we see:
       - digit: build currNum
       - '[': recursively decode the substring inside, then repeat it currNum times
       - ']': return the built string for this recursion level

     Time Complexity: O(n * expansion)
     Space Complexity: O(n)
       - recursion stack depth + output building
     */
    public String decodeStringUsingRecursion(String s) {
        idx = 0; // reset before starting a new decode
        return decode(s);
    }

    private String decode(String s) {
        int currNum = 0;
        StringBuilder currString = new StringBuilder();

        while (idx < s.length()) {
            char c = s.charAt(idx);
            idx++;

            if (Character.isDigit(c)) {
                currNum = currNum * 10 + (c - '0');
            } else if (c == '[') {
                // decode inside brackets
                String inner = decode(s);

                // repeat inner currNum times
                for (int k = 0; k < currNum; k++) {
                    currString.append(inner);
                }
                currNum = 0; // reset after using it
            } else if (c == ']') {
                // end of this bracketed segment
                return currString.toString();
            } else {
                currString.append(c);
            }
        }

        return currString.toString();
    }

    //  Simple main method to test (no assertions)
    public static void main(String[] args) {
        DecodingString solver = new DecodingString();

        String[] tests = {
                "3[a]2[bc]",
                "3[a2[c]]",
                "2[abc]3[cd]ef",
                "10[a]",
                "abc3[cd]xyz"
        };

        System.out.println(" Iterative (Stacks) ");
        for (String t : tests) {
            System.out.println("Input : " + t);
            System.out.println("Output: " + solver.decodeString(t));
            System.out.println();
        }

        System.out.println(" Recursive ");
        for (String t : tests) {
            System.out.println("Input : " + t);
            System.out.println("Output: " + solver.decodeStringUsingRecursion(t));
            System.out.println();
        }
    }
}
