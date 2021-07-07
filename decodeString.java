// Time Complexity :O(n) n is the length of the string 
// Space Complexity : O(n) n is the length of the string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    int i = 0;
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return s;
        int num = 0;
        StringBuilder result = new StringBuilder();
        while(i<s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = (num*10) + (c - '0');
                i++;
                System.out.println(num);
            }
            else if(c == '['){
                i++;
                String sub = decodeString(s);
                for(int k = 0; k< num; k++){
                    result.append(sub);
                }
                num = 0;
                
            }
            else if(c==']'){
                i++;
                return result.toString();
            }
            else{
                result.append(c);
                i++;
            }
            
        }
        
        return result.toString();
    }
}