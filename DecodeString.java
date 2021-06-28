// Time Complexity : O(max(num) x max(length of string)) = O(k x N)
// Space Complexity : O(length of string) = O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Doing i++ before recursively calling the function. 

class Solution {
    int i;
    public String decodeString(String s) {
        // base
        if(s == null || s.length() == 0)
            return s;
        
        StringBuilder str = new StringBuilder();
        int num = 0;
        
        //logic
        while(i < s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + Character.getNumericValue(c);
                i++;
            }
            else if(Character.isLetter(c)){
                str.append(Character.toString(c));
                i++;
            }
            else if(c == '['){
                i++;
                String newStr = decodeString(s);
                StringBuilder nstr = new StringBuilder();
                for(int j=0; j<num; j++)
                    nstr.append(newStr);
                str.append(nstr);
                num = 0;
            }
            else{
                i++;
                return str.toString();
            }
        }
        
        return str.toString();
    }
}
