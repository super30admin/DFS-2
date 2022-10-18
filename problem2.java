package DFS-2;

public class problem2 {
// Time Complexity : O(n * k) n is strings length and k is max no. in string
// Space Complexity : O(m) m is depth of string means number of opening brrackets
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

int i;
    public String decodeString(String s) {
        //DFS
        
        //base
        if(s == null || s.length() == 0) return "";
        
        int num = 0;
        StringBuilder currStr = new StringBuilder();
        
        while( i < s.length()){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
                i++;
            }else if(c == '['){
                i++;
                String decode = decodeString(s);
                //pop
                StringBuilder newStr = new StringBuilder();
                for(int j = 0; j < num; j++){
                    newStr.append(decode);
                }
                currStr.append(newStr);
                num = 0;
            }else if(c == ']'){
               i++;
                return currStr.toString();
            }else{
                i++;
                currStr.append(c);
            }
        }
        
        return currStr.toString();
    }
}
