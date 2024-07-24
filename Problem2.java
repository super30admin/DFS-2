//Time = O(n)
//Space = O(n)

class Solution {
    public String decodeString(String s) {
        // Create two stacks to store numbers and strings
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        // Create a current string to store the current decoded string
        StringBuilder currStr = new StringBuilder();
        // Create a current number to store the current multiplier
        int currNum = 0;

        // Iterate through each character in the input string
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // If the character is a digit, update the current number
                currNum = currNum * 10 + c - '0';
            } else if (c == '[') {
                // If the character is an opening bracket, push the current number and string to their respective stacks
                numStack.push(currNum);
                strStack.push(currStr);
                // Reset the current number and string
                currNum = 0;
                currStr = new StringBuilder();
            } else if (c == ']') {
                // If the character is a closing bracket, pop the previous string from the stack and repeat it the number of times specified by the number on the top of the numbers stack
                StringBuilder temp = currStr;
                currStr = strStack.pop();
                for (int i = numStack.pop(); i > 0; i--) {
                    currStr.append(temp);
                }
            } else {
                // If the character is a letter, append it to the current string
                currStr.append(c);
            }
        }

        // Return the final decoded string
        return currStr.toString();
    }
}


//-----------------------------------------Brute Force Approach--------------------------------------------------------------------------------
class Solution {
    public String decodeString(String s) {
        // Create a stack to keep track of previously processed characters
        Stack<String> stack = new Stack<>();
        // Create a result string to store the final decoded string
        String res = "";
        // Initialize an index variable i to 0 to start iterating through the input string
        int i = 0;
        
        // Loop through the input string character by character
        while (i < s.length()) {
            // Get the current character at index i
            char c = s.charAt(i);
            
            // If the current character is a digit
            if (Character.isDigit(c)) {
                // Parse the number and add it to the stack
                int num = 0;
                while (Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                stack.push(Integer.toString(num));
            } 
            // If the current character is a letter
            else if (Character.isLetter(c)) {
                // Add the letter to the result string
                res += c;
                i++;
            } 
            // If the current character is an opening bracket
            else if (c == '[') {
                // Push the current result string onto the stack and reset it to an empty string
                stack.push(res);
                res = "";
                i++;
            } 
            // If the current character is a closing bracket
            else if (c == ']') {
                // Pop the previous string and the number of times it should be repeated from the stack
                String prevStr = stack.pop();
                int times = Integer.parseInt(stack.pop());
                // Create a StringBuilder to repeat the previous string the required number of times
                StringBuilder sb = new StringBuilder(prevStr);
                for (int j = 0; j < times; j++) {
                    sb.append(res);
                }
                // Set the result string to the repeated string
                res = sb.toString();
                i++;
            }
        }
        // Return the final decoded string
        return res;
    }
}
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
