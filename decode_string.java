// Time Complexity : O(n * max(k)) where n -length of the string and k -  max number in the string
// Space Complexity : O(m + n + k) m - len of unique characters, n - len of unique digits and 
// k - append computation

class Solution {
    public String decodeString(String s) {
        
        String currString = "";
        int currNum = 0;
        
        // Stack for alphabet
        Stack<String> strStack = new Stack<>();
        
        // Stack for numbers
        Stack<Integer> numStack = new Stack<>();
        
        // Iterate through each character
        for (int i=0; i < s.length(); i++){
            
            // current character
            char c = s.charAt(i);
            
            // opening bracket
            if (c == '['){
                
                // Store the currString and currNum into the stack
                strStack.push(currString);
                numStack.push(currNum);
                
                // Start again as [ - indicates a new sub problem started
                currString = "";
                currNum = 0;
            }
            
            // closing bracket
            else if (c == ']'){
                
                // pop from the num Stack and multiply the character that many times
                int poppedNum = numStack.pop();
                String temp = "";
                
                for (int j = 0; j < poppedNum ; j++){
                    temp = temp + currString;
                }
                
                // pop from the string stack and append that at the beginning
                currString = strStack.pop() + temp;
            }
            
            // number
            else if (Character.isDigit(c)){
                
                // c is char so c-0 gives the digit
                currNum = currNum * 10 + (c - '0');
                
            }
            
            // alphabet
            else{
                // append the char to the current String
                currString += c;
            }
        }
        
        
        return currString;
    }
}