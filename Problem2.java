// 394. Decode String

class Solution {
    public String decodeString(String s) {
        
        if(s == null || s.length() == 0 ) return s;
        
        int currNum = 0; String currStr = "";
        
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            
            //case 1
            if(Character.isDigit(c)){
                currNum = currNum*10 + c - '0';
            } else if(c.equals( '[' ) ){
                numStack.push(currNum);
                strStack.push(currStr);
                
                currNum = 0; 
                currStr = ""; 
            } else if(c.equals(']')){
                int times = numStack.pop();
                StringBuilder newString = new StringBuilder();
                
                for(int k = 0; k < times; k++){
                    newString.append(currStr);
                }
                
                currStr = strStack.pop() + newString;
            } else {
                currStr += c;
            }
        }
        
        return currStr; 
    }
}


/* 
Complexity Analysis

Time Complexity: 
O(maxK countK⋅n), where maxK is the maximum value of k, 
 count K is the count of nested k values and n is the maximum length of encoded string. 
Space Complexity:
The maximum stack size would be equivalent to the sum of all the decoded strings in the form 
maxK[nmaxK[n]]
  
*/