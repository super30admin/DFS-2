// Time Complexity : O(n), where n is the length of the string
// Space Complexity : O(n), where n is the length of the string (space for the 2 stacks)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three Liner approach of your code in plain english
//1. create 2 stacks, one for numbers and for the string uptill that point. Iterate over the given stringm and at each index check
        //if it is a number, add it to the num variable
        //if it is a opening bracket, that means you have a child to process, so push the current number and string in the 2 stacks
                //and start processing the child
        //if it is a plain character, append it to the current string
        //if it is a closing bracket, proccess the child by poping the nums stack and multiplying current string that many times
                //and poping the string stack and apping the above result to it
//2. Keep doing the above, still the entire input string is traversed
//3. return the current string as it the decoded string

// Your code here along with comments explaining your approach

class Solution {
    public String decodeString(String s) {
        if(s == null && s.length() == 0) return s;
        
        //stack to store the number
        Stack<Integer> numSt = new Stack<>();
        //stack to store the characters
        Stack<StringBuilder> strSt = new Stack<>();
        //to maintain the current number
        int currNum = 0;
        //to maintain the current String
        StringBuilder currS = new StringBuilder();
        //to maintain the final decoded String
        StringBuilder result = new StringBuilder();
        
        //Iterate over the entire String s
        for(int i=0; i<s.length(); i++){
            //get the charcter at index i
            char c = s.charAt(i);
            //if c is a number
            if(Character.isDigit(c)){
                //update the current number
                currNum = currNum*10 + c-'0';
            }
            else if(c == '['){ //c is an opening bracket
                //push the current string and number in the respective Stacks 
                numSt.push(currNum);
                strSt.push(currS);
                //Reset the current string and number
                currNum =0;
                currS = new StringBuilder();
            }
            else if(c == ']'){ //c is closing bracket
                //new String 
                StringBuilder newStr = new StringBuilder();
                //pop the current number from the stack and multiply the current string to current number
                int times = numSt.pop();
                for(int j=0; j<times; j++){
                    newStr.append(currS);
                }
                //pop the string from the stack and append it to the new String
                currS = strSt.pop().append(newStr);
                
            }
            else{ //c is a charcter
                //update the current string
                currS.append(c);
            }
        }
        //current String is the decoded String
        return currS.toString();
    }
}