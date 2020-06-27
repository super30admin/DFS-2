
// Time complexity - O(length of decoded string)
// Space complexity - O(length of given string)

// Recursive solution

class Solution {
    int  i = 0;
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return s;
        int num = 0;
        StringBuilder result = new StringBuilder();
       while(i < s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num =  num*10 + c - '0';
                i++;
            }else if(c == '['){
                i++;
                String inner = decodeString(s);
                for(int  k = 0 ; k < num; k++){
                    result.append(inner);
                }
                num = 0;
            }else if(c == ']'){
                i++;
                return result.toString();
            }else{
                result.append(c);
                i++;
            }
        }
        return result.toString();
    }
}
