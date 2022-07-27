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
                String decodeString = decodeString(s);
                StringBuilder newString = new StringBuilder();
                for(int j = 0; j < num; j++){
                    newString.append(decodeString);
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