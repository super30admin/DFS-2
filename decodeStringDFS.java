// Time Complexity : O(kN)
// Space Complexity : O(kN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class decodeDFS {
    int i = 0;
    public String decodeString(String s) {
        if(s == null || s.length() == 0)
            return s;
        
        int num = 0;
        StringBuilder currStr = new StringBuilder();
        
        while(i < s.length()){
            char c = s.charAt(i);
            
            //digit
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
                i++;
            }
            //[
            else if(c == '['){
                i++;
                String child = decodeString(s);
                StringBuilder newStr = new StringBuilder();
                for(int k = 0; k < num; k++){
                    newStr.append(child);
                }
                currStr.append(newStr);
                num = 0;                
            }
            //]
            else if(c == ']'){
                i++;
                return currStr.toString();
                
            }
            else{
                currStr.append(c);
                i++;
            }
        }
        
        return currStr.toString();
    }
}