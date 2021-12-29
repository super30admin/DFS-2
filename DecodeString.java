// Time Complexity :O(max Num * n)
// Space Complexity :O(m+n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public String decodeString(String s) {
        
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        
        String currStr = "";
        int currNum = 0;
        
        for(int i = 0 ; i < s.length() ; i++){
            
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                
                currNum = currNum * 10 + c - '0';
                
            }else if(c == '['){
                
                stringStack.push(currStr);
                numStack.push(currNum);
                currStr = "";
                currNum = 0;
                
            }else if(s.charAt(i) == ']'){
        
               int count = numStack.pop();
               StringBuilder str = new StringBuilder();
                
                for(int j = 0 ; j < count ; j++){
                    
                   str.append(currStr); 
                }
                currStr = stringStack.pop();
                currStr += str;
            }else{
                currStr += c;
            }
        }
        
        return currStr;
    }
}
