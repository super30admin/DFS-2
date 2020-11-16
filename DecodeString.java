// Time Complexity : o(nk) k is times, n is len of string
// Space Complexity : 1 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Leetcode : 394
//Approach :  Iterative

class Solution {
    public String decodeString(String s) {
        if(s.length() == 0 || s == null) return s;
        
        StringBuilder curr = new StringBuilder();
        int num  = 0 ;
        
        Stack<StringBuilder> strSt = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = num*10 + c - '0';
            }
            else if(c == '['){
                strSt.add(curr);
                numSt.add(num);
                
                curr = new StringBuilder();
                num = 0 ;
            }
            else if(c == ']'){
                int times  = numSt.pop();
                
                StringBuilder newStr = new StringBuilder();
                for(int j = 0 ; j < times ; j++){
                    newStr.append(curr);
                }
                curr = strSt.pop().append(newStr);
            }
            else{
                curr.append(c);
            }
        }
        return curr.toString();   
    } 
}