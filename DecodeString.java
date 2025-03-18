// In this problem, we are iterating through given string and keeping num variable, currStr variable, numStack and strStack. Whenever a digit found
// put it in num, whenever character append it to currStr. Whenever '[' found, do stack push and whenever ']' do pop and process the innermost
// nested string. 

// Time Complexity : O(n) - n is the length of final decoded string
// Space Complexity : depth of string or number of nested levels
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public String decodeString(String s) {
        // Base Case
        if (s == null || s.length() == 0) {
            return "";
        }
        // Declare 2 variables and 2 stacks
        StringBuilder currStr = new StringBuilder();
        int num = 0;
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        // Run a loop
        for (int i = 0; i < s.length(); i++) {
            // Get a single char
            char c = s.charAt(i);
            // Check if it is digit
            if (Character.isDigit(c)) {
                // update num
                num = num * 10 + (c - '0');
            }
            // If '[' then stack.push and reset num and currStr
            else if (c == '[') {
                numStack.push(num);
                strStack.push(currStr);
                num = 0;
                currStr = new StringBuilder();
            }
            // If ']', first numStack.pop and run a loop that many times and append currStr
            // and build a new string
            else if (c == ']') {
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for (int j = 0; j < times; j++) {
                    // repeat that innermost string for the given times
                    newStr.append(currStr);
                }
                // Then append this new string to the string store in strStack
                currStr = strStack.pop().append(newStr);
            } else {
                // If char, simply append to currStr
                currStr = currStr.append(c);
            }
        }
        // return currStr
        return currStr.toString();
    }
}

// Recursive solution
class Solution {
    // Declare i globally because we want the old value of i whenever a recursive
    // call is made, we dont want it to initialize it to 0 again
    int i;

    public String decodeString(String s) {
        // Base case
        if (s == null || s.length() == 0) {
            return "";
        }
        // Declare 2 variables, because we want our currStr and num to reset to 0 on
        // every recursive call, because old value will be stored in stack
        StringBuilder currStr = new StringBuilder();
        int num = 0;
        // Iterate till the length of string
        while (i < s.length()) {
            // Take one char at a time
            char c = s.charAt(i);
            // If digit, simply get it's value in num and increment i
            if (Character.isDigit(c)) {
                i++;
                num = num * 10 + c - '0';
            }
            // Whenever opening bracket, we want stack.push so recursive call will do that
            // for us
            else if (c == '[') {
                i++;
                // Recursive call
                String decoded = decodeString(s);
                // After the call is completed, our latest string will be stored in decoded and
                // currstr and num will get values due to stack.pop
                // Declare a new str
                StringBuilder newStr = new StringBuilder();
                // Since num is having the value of stack.pop, we want our decoded string to be
                // repeated that many times
                for (int i = 0; i < num; i++) {
                    newStr.append(decoded);
                }
                // Then whatever value of currstr from stack, append to it the value of newstr
                currStr.append(newStr);
                // Set num to 0
                num = 0;
            } else if (c == ']') {
                // If closing bracket, simply return the value of currstr and complete the
                // recursive call, since we want stack.pop
                i++;
                return currStr.toString();
            } else {
                // If char, simply append to currStr
                i++;
                currStr.append(c);
            }
        }
        // Return currStr
        return currStr.toString();

    }
}