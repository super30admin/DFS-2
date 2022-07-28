// Time Complexity : Max(num)XO(N)
// Space Complexity : Depth of [] nesting
// Did this code successfully run on Leetcode : Yes

class Solution {
    int i;
    public String decodeString(String s) {
        if(s==null || s.length()==0){
            return "";
        }
        StringBuilder cur = new StringBuilder();
        int num = 0;
        
        while(i<s.length()){
           char c = s.charAt(i);
            i++;
            if(Character.isDigit(c)){
                num = num * 10 +c - '0';
            }
            else if(c == '['){
                String decoded = decodeString(s);
                StringBuilder newStr = new StringBuilder();
                for(int n=0;n<num;n++){
                    newStr.append(decoded);
                }
                cur.append(newStr);
                num=0;
            }
            else if(c == ']'){
                return cur.toString();
            }
            else{
                cur.append(c); 
            }
        }
        return cur.toString();
    }
}