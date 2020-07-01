// Time Complexity :  O(n*K)
// Space Complexity : O(n*K)
// Did this code successfully run on Leetcode : yes 				
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public String decodeString(String s) {
        int curNum = 0;
        StringBuilder curString = new StringBuilder();
        String encodedString="";
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> charStack = new Stack<>();
        for(int i = 0; i < s.length() ; i++){
               char c =  s.charAt(i);
            //case 1 number
            if(Character.isDigit(c)){
                curNum =  curNum*10 + Integer.parseInt(String.valueOf(c));
                
            }
            //case 2 if it is open bracket
            else if(c == '['){
                numStack.push(curNum);
                charStack.push(curString);
                curNum = 0 ;
                curString = new StringBuilder();
            }
            //case 3 if it is close bracker
            else if(c == ']'){
                int times = numStack.pop();
                StringBuilder newString  = new StringBuilder();
                for(int j = 0; j < times ;j++){
                    newString.append(curString);
                }
                curString = charStack.pop().append(newString);
            }
            //if it is character
            else
                curString.append(c);
            
        }
        
        return curString.toString();
        
    }
}