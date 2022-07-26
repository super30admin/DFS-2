//Time Complexity: O(n) where n is the size of the decoded string
//Space Complexity: O(n) where n is the number of characters in the given string. 

class Solution {
    int i;
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        
        StringBuilder currString = new StringBuilder();
        int num = 0; 
        
        
        while( i < s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
                i++;
            }
            else if(c == '['){
                i++;
                String decode = decodeString(s);
                StringBuilder newString = new StringBuilder();
                for(int j = 0; j < num; j++){
                    newString.append(decode);
                }
                currString.append(newString);
                num = 0;
            }
            else if(c == ']'){
                i++;
                return currString.toString();
            }
            else{
                currString.append(c);
                i++;
            }
        }
        return currString.toString();
    }
}