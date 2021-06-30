// Time Complexity : O(L), L - length of String
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class DecodeString {
    int i = 0;
    public String decodeString(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        
        int num = 0;
        StringBuilder str = new StringBuilder();
        
        while(i < s.length()){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
                i++;
            }
            else if(c == '['){
                i++;
                String child = decodeString(s);
                StringBuilder newStr = new StringBuilder();
                for(int i=0; i<num; i++){
                    newStr.append(child);
                }
                str.append(newStr);
                num = 0;
            }
            else if(c == ']'){
                i++;
                return str.toString();
            }
            else{
                str.append(c);
                i++;
            }
        }
        return str.toString();
    }
}