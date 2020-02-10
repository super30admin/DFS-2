//Time Complexity  - O(n) where n is the length of the string


//Space Complexity - O(n) where n is the length of the string


class Solution {
    public String decodeString(String s) {
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        
        String currentString ="";
        
        int currentNum = 0;
        
        for(int i=0;i<s.length();i++){
            
            char c =  s.charAt(i);
            
            if(Character.isDigit(c)){           // Store it in currentNum
               currentNum = currentNum * 10 + c - '0';
            }
            else if(Character.isLetter( c)){      
                currentString = currentString + c; //Store it in currentString
            }
            else if(s.charAt(i) == '['){
    //Push the two variables in the two stacks and reset their values
               stringStack.push(currentString);
                numStack.push(currentNum);
                currentNum = 0;
                currentString = "";
            }
            else if(s.charAt(i) == ']'){
                
                StringBuilder newString = new StringBuilder();
                int times = numStack.pop();
                for( int j =0;j < times;j++){
                    newString.append(currentString); //currentString has the repeat portion between the brackets
                }
                // presentInTheStack + newString
                currentString = stringStack.pop() +newString; 
            }
        }
        
        return currentString;
    }
}