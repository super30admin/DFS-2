/* 
DECODE STRING PROBLEM, LEETCODE PBM #394

Time Complexity: O(n) as we are traversing through the entire string.
Space comlexity: O(n), 2 stacks used.
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Algorithm:
    - We will traverse through the string, When we come accross a digit we will convert that to int.
    - When we hit '[' we push both the current num and current string into separate stacks(Also reset current num and current string). When we hit ']' we will loop through the number of times from the top of stack and build a string from the current string. After coming out of the for loop we will add this new string to the top element of the string stack.
    - If we have a letter then we keep adding it to the curr string.
    
*/

class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> integerStack = new Stack<>(); 
        Stack<String> stringStack = new Stack<>();
        
        int currNum = 0;
        String currString = "";
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c))
                currNum = currNum*10 + (c-'0'); //Retrieving the number
             else if(c=='['){
            integerStack.push(currNum); // Pushing the number in stack
            stringStack.push(currString);// Pushing the current string in stack
            currString="";// Resetting the current string and current number
            currNum=0; 
        }
        else if(c==']'){
            int count = integerStack.pop();
            StringBuilder sb = new StringBuilder(); //Form a new string with what is there in the current string
            for(int j=0;j<count;j++){
                sb.append(currString);
                
            }
            
            currString = stringStack.pop(); 
            currString+=sb; //Append the string to current string
            
            
        }
        else{
            currString+=c; //If none of the above cases match, keep building the string.
        }
        }
       
        return currString;
        
    }
}