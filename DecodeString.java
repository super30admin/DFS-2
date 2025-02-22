// Time complexity:- max (k, n) k is the products of numbers in the input and n is the length of the input
// Space complexity:- max (k, n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/**
 * Approach:
 * This problem is about decoding a string where a number followed by a string in square brackets indicates that the string should be repeated that many times.
 * I used two stacks: one to store the repetition counts and another to store the partially decoded strings.
 * By iterating through the input string, I build the decoded string step-by-step, using the stacks to handle the nested repetitions correctly.
 */
class Solution {
    public String decodeString(String s) {
        // to store number
        Stack<Integer> numSt = new Stack<>();

        // to store string 
        Stack<StringBuilder> strSt = new Stack<>();

        //StringBuilder for current decoded String
        StringBuilder currStr = new StringBuilder();

        //Variable to store current number
        int currNum = 0;

        // Iterate through character in the input String
        for(int i = 0; i < s.length(); i++) {

            //Get the current character
            char ch = s.charAt(i);

            //if the character is digit
            if(Character.isDigit(ch)) {
                currNum = currNum * 10 + ch - '0';

            // If the character is an opening bracket '['
            } else if(ch == '[') {
                // Push the current number and the current string in the stack
                numSt.push(currNum);
                strSt.push(currStr);

                // Reset currNum to zero
                currNum = 0;

                //make currNum to empty string
                currStr = new StringBuilder();

            // If the character is a closing bracket ']'
            } else if(ch == ']') {

                 // Pop the number from the stacks
                int count = numSt.pop();

                // Build the substring by repeating the current string count times
                StringBuilder child = new StringBuilder();
                for(int k = 0; k < count; k++) {
                    child.append(currStr);
                }
                // Pop the previous string and combine the child with parent
                StringBuilder parent = strSt.pop();
                currStr = parent.append(child);

            // If the character is a letter, simply append it to the current string
            } else {
                currStr.append(ch);
            }
        }
        // After the loop, currStr contains the fully decoded string
        return currStr.toString();
        
       }
}