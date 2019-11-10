/*
Author: Akhilesh Borgaonkar
Problem: LC 394. Decode String (DFS-2)
Approach: Using iterative approach here to traverse through the string and perform set of action according to current character at index.
Time Complexity: O(n) where n is length of input string.
Space complexity: O(n) where n is length of input string.
LC verified.
*/

class Solution {
    public String decodeString(String s) {
        
        Stack<String> letters = new Stack<>();  //stack to store characters in string
        Stack<Integer> numbers = new Stack<>(); //stack to store numbers in string
        int len = s.length();       
        String currStr = "";    //buffer to store the current string
        Integer currNum = 0;    //buffer to store the current number
        
        for(int i=0; i<len; i++){   //parsing through the string
            char c = s.charAt(i);   //getting the character at currently iterating index
            
            if(Character.isDigit(c))        //if number is found then update the current number buffer
                    currNum = currNum * 10 + c - '0';
                    
             else if(c == '['){             //if '[' is found then push the buffered number and string to stacks and reset them
                    letters.push(currStr);
                    numbers.push(currNum);
                    currStr = "";
                    currNum = 0;
             }
                        
            else if(c == ']'){              //if ']' is found then pop the last number in stack and append the current buffered string that many times to current string
                    int lastNum = numbers.pop();
                    StringBuilder newStr = new StringBuilder();
                    for(int j=0; j<lastNum; j++)
                        newStr.append(currStr);
                    String temp = letters.pop();
                    currStr = temp+newStr;
            }      
            else                    //if character is found then append it to current string buffer
                    currStr += c;
        }
        return currStr;             //finally return the current string buffer
    }
}