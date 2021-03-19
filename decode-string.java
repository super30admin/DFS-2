//Time complexity : O(n) [n = length of string]
//Space complexity : O(n)
// Did this code successfully run on Leetcode :
Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public String decodeString(String s) {
        //base case
        if(s == null || s.length() == 0) return "";
        
        //define two stacks to store numbers in the given string and characters
        
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        
        //define the variabled needed to process the result
        String str = "";
        int num = 0;
        
        //traverse the string
        for(int i = 0; i< s.length();i++){
            char c = s.charAt(i);
            //check if c is digit, string, open brace or close brace
            
            if(Character.isDigit(c)){
                //convert character to num
                num = num * 10 + (c - '0');
            }
            /*If it is open brace we will push the current number and current string to respective stacks*/
            else if(c == '['){
                numStack.push(num);
                strStack.push(str);
                
                //now reset the num and str to process remaining string
                str = "";
                num = 0;
            }
/*
if it is closing brace we will pop from number stack and create a new string with this number and the current string stored in str
*/
            else if(c == ']'){
                String newStr = "";
                int numPopped = numStack.pop();
                
                for(int k = 0; k<numPopped; k++){
                    newStr += str;
                    
                    }
                
                str = strStack.pop();
                str = str + newStr;
            }
            //if it's a character append to str
            else{
                str += c;
            }
        }
      return str;  
    }
}