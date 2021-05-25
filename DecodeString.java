// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n) where n is the length of the string, since we are iterating through the entire string
//Space Complexity: O(n) since we are using stacks to keep track of digits and strings.

 class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return s;
        
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int number = 0;
        String currString = "";
        
        for(int i = 0; i < s.length(); i++){
            
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                number = number * 10 + c - '0';
            }
            else if(c == '['){
                numStack.add(number);
                strStack.add(currString);
                number = 0;
                currString = "";
            }
            else if(c == ']'){
                int numOfTimes = numStack.pop();
                String newStr = "";
                for(int j = 0; j < numOfTimes; j++){
                    newStr = newStr + currString;
                }
                currString = strStack.pop() + newStr;
            }
            else{
                currString = currString + c;
            }            
        }
        
        return currString;
    }
}