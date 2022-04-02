
// Time Complexity : O(max(All k's) * n)
// Space Complexity : O(k * n)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    int i;
    public String decodeString(String s) {
        if(s == null || s.length() == 0)   return s;
        
        StringBuilder currString = new StringBuilder();
        int currNum = 0;
         
        while(i < s.length()){//Iterating input string by 1 character everytime
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch) ){ // If it is digit, update the value of currNum
                i++;
                currNum = currNum * 10 + ch - '0';  
            }
            else if(ch == '['){ // If '[' encountered, will call recursive function from next char 
                i++;
                String temp = decodeString(s);
                
                for(int x = 0; x< currNum; x++){ //Will decode the string here
                    currString.append(temp);
                }
                currNum = 0;
            }
            else if(ch == ']'){// If ']' encountered, will call return the current string for decoding 
                i++;
                
                return currString.toString();
             }
            else{ // ch == any letter
                currString.append(ch);  //If it is letter, just append that letter in currString
                i++;
            }
        }
        return currString.toString();
    }
}





/*

class Solution {
    public String decodeString(String s) {
       if(s == null || s.length() == 0)   return s;
        
        StringBuilder currString = new StringBuilder();
        int currNum = 0;
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> charStack = new Stack<>();        
        for(int i = 0; i< s.length(); i++){//Iterating input string by 1 character everytime
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch) ){ // If it is digit, update the value of currNum
                currNum = currNum * 10 + ch - '0';  
            }
            else if(ch == '['){ // If '[' encountered, will push the values of cuurent number and string into the stacka
                numStack.push(currNum);
                charStack.push(currString);
                currString = new StringBuilder();
                currNum = 0;
                
            }
            else if(ch == ']'){ // If ']' encountered, will pop the number from stack for decoding 

                int r = numStack.pop();
                StringBuilder temp = new StringBuilder();
                for(int p = 0; p< r; p++){
                    temp.append(currString); 
                } //Decoded string
                
                currString = charStack.pop().append(temp); // Append with its parent string by popping from stringStack
                
            }
            else{ // ch == any letter // //If it is letter, just append that letter in currString
                currString.append(ch);
            }
        }
        
        return currString.toString();
    }
}

*/