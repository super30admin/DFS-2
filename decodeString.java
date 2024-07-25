// Time Complexity : O(Maxk*n) - MaxK is is product of K and n is length of string
// Space Complexity : O(n+n) - m is number of numbers and n is number of letters in a string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public String decodeString(String s) {
        // StringBuilder to build the current string being processed
        StringBuilder currentParent = new StringBuilder();
        // Integer to keep track of the current repeat count
        int currentInt = 0;
        // Stack to store StringBuilder instances for nested structures
        Stack<StringBuilder> ParentStringStack = new Stack<>();
        // Stack to store repeat counts for nested structures
        Stack<Integer> ParentIntegerStack = new Stack<>();
        
        // Iterate through each character in the input string
        for (int i = 0; i < s.length(); i++) {
            char currentCharacter = s.charAt(i); // Get the current character
            
            if (Character.isDigit(currentCharacter)) {
                // Build the current repeat count (currentInt)
                currentInt = currentInt * 10 + (currentCharacter - '0');
            } else if (currentCharacter == '[') {
                // Push the current StringBuilder and repeat count to their respective stacks
                ParentStringStack.push(currentParent);
                ParentIntegerStack.push(currentInt);
                // Reset currentInt and currentParent for new substring
                currentInt = 0;
                currentParent = new StringBuilder();
            } else if (currentCharacter == ']') {
                // Pop the repeat count from the stack
                int stackInt = ParentIntegerStack.pop();
                // Create a temporary StringBuilder to build the repeated substring
                StringBuilder temp = new StringBuilder();
                
                // Append currentParent string stackInt times to temp
                for (int k = 0; k < stackInt; k++) {
                    temp.append(currentParent);
                }
                // Pop the last StringBuilder from the stack and append temp to it
                StringBuilder lastParent = ParentStringStack.pop();
                currentParent = lastParent.append(temp);
            } else {
                // Append the current character to the currentString
                currentParent.append(currentCharacter);
            }
        }
        
        // Return the fully decoded string
        return currentParent.toString();
    }
}
