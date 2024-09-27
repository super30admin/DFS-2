class Solution {
    int i;
    public String decodeString(String s) {
        if(s.length() == 0 || s == null) return s;
        
        int num = 0; StringBuilder currstr = new StringBuilder();
        
        
        while(i < s.length()){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
                i++;
            }else if (c == '['){
                i++;
                String child = decodeString(s);
                StringBuilder newstr = new StringBuilder();
                for(int k = 0; k< num ; k++){
                    newstr.append(child);
                }
                currstr.append(newstr);
                num = 0;
            } else if(c == ']'){
                i++;
                return currstr.toString();
            } else{
                currstr = currstr.append(c);
                i++;
            }
        }
        return currstr.toString();
        
    }
}


//TC : O(N)
