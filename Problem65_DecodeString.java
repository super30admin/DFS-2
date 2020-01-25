/***************** Time Complexity: O(n) ****************** */
/***************** Space Complexity: O(n) ****************** */

class Solution {
    
    public String decodeString(String s) {
        
        //base case
        if(s == null || s.length() == 0)
            return "";
        
        //create stacks for letters and numbers
        //to keep 1-1 relationship between strings and numbers
        Stack<String> letters = new Stack<>();
        Stack<Integer> numbers = new Stack<>();
        
        //initialization
        int length = s.length();
        //resultant string and number
        String currString = "";
        Integer currNumber = 0;
        
        //till length = 0
        for(int i=0; i<length; i++){
            //for each character
            char c = s.charAt(i);
            //checking if its a digit
            if(Character.isDigit(c))
                    //ascii -> 10* (earlier number) 0 + (50-47)
                    //47 -> ascii value of 0 
                    currNumber = currNumber * 10 + c - '0';
                    
            else if(c == '['){
                    //add in string and integer stack
                    letters.push(currString);
                    numbers.push(currNumber);
                    //reset
                    currString = "";
                    currNumber = 0;
             }
                    
            else if(c == ']'){
                    //take number out -> new corresponding string
                    //number of times you want to process the string
                    //pop from number stack
                    int lastNumber = numbers.pop();
                    StringBuilder newStr = new StringBuilder();
                    for(int j=0; j<lastNumber; j++)
                        //adding to the string
                        newStr.append(currString);
                        String temp =letters.pop();
                    currString = temp+newStr;
            }      
            else
                    //if a string, add to the current string
                    currString += c;
        }
        return currString;
    }
}