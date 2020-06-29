// Time Complexity :O(n*k)
// Space Complexity :O(n + k) height of the stack 
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0)return s;
        int currNum = 0;
        StringBuilder currstr = new StringBuilder();
        Stack<Integer> numStack =new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            //case1
            if(Character.isDigit(c)){
                currNum = currNum *10 + c-'0';
            }
            //case2
            else if(c == '['){
                numStack.push(currNum);
                strStack.push(currstr);
                currNum = 0;
                currstr = new StringBuilder();
            }
            else if(c == ']'){
                int times = numStack.pop();
                StringBuilder newString = new StringBuilder();
                for(int k = 0; k < times; k++){
                    newString.append(currstr);
                }
                currstr = strStack.pop().append(newString);
            }
            else{
                currstr.append(c);
            }
        }
        return currstr.toString();
    }
}