// Time Complexity : O(NK)
// Space Complexity : O(NK)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        
        int currNum = 0;
        String currString = "";
        for(int i = 0 ; i < s.length() ; i++){
           
            if(Character.isDigit(s.charAt(i))){
                currNum = currNum * 10 + (s.charAt(i)-'0');
                                
                
            }else if(s.charAt(i) == '['){
                numStack.push(currNum);
                strStack.push(currString);
                currNum = 0;
                currString = "";
            }else if(s.charAt(i) == ']'){
                int count = numStack.pop();
                StringBuilder temp = new StringBuilder();
                for(int j = 0 ; j < count ; j++){
                    temp.append(currString);
                }
                currString = strStack.pop()+temp.toString();
            }else{
                currString += s.charAt(i);
            }
        }
        return currString.toString();
    }
}
