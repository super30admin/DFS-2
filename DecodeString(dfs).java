// Time Complexity :O(n*k)
// Space Complexity :O(n + k) height of the stack 
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


class Solution {
    int i = 0;
    public String decodeString(String s) {
        if(s == null || s.length() == 0)return s;
        int num = 0;
        StringBuilder resultstr = new StringBuilder();
        
        while(i<s.length()){
            char c = s.charAt(i);
            //case1
            if(Character.isDigit(c)){
                i++;
                num = num *10 + c-'0';
            }
            //case2
            else if(c == '['){
                i++;
                String inner  = decodeString(s);
                for(int k = 0; k < num; k++){
                    resultstr.append(inner);
                }
                num = 0;
                
            }
            else if(c == ']'){
                i++;
                return resultstr.toString();
            }
            else{
                i++;
                resultstr.append(c);
            }
        }
        return resultstr.toString();
    }
}