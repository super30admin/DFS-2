// Time Complexity: not sure how to define in Big-Oh notation. Please help.
//Space Complexity: O(depth) where depth is equivalent to the amount of nested strings given

class Solution {
    int i;
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return s;
        int num = 0;
        StringBuilder curr = new StringBuilder();
        
        while(i < s.length()){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
                i++;
            } else if(c == '['){
                i++;
                String child = decodeString(s);
                StringBuilder newStr = new StringBuilder();
                for(int j=0; j< num; j++){
                    newStr.append(child);
                }
                curr.append(newStr);
                num = 0;
            } else if(c == ']'){
                i++;
                return curr.toString();
            } else{
                curr.append(c);
                i++;
            }
        }
        return curr.toString();
    }
}