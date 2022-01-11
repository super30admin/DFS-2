//Time: O(number of chars * max(total number of chars))
//Space: number of chars + number of digits + k(total number of chars)
//https://leetcode.com/submissions/detail/617266230/
class Solution {
    public String decodeString(String s) {
        String currString = "";
        int currNumber = 0;
        
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            
            Character c = s.charAt(i);
            
            if(Character.isDigit(c)) {
                
                currNumber = currNumber * 10 + (c - '0');
            
            } else if ( c == '['){
                
                strStack.push(currString);
                numStack.push(currNumber);
                
                currString = "";
                currNumber = 0;
            
            } else if( c == ']') {
                
                int poppedNum = numStack.pop();
                String temp = "";
                
                for(int j = 0; j < poppedNum; j++) {
                    
                    temp = temp + currString;
                }
                
                currString = strStack.pop() + temp;
            
            } else {
                  
                currString += c;
                
            }
        }
        return currString;
    }
}