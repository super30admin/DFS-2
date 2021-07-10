// Time Complexity : O(m * n) m - max digit, n - max string
// Space Complexity : O(h) h - length of stack

class Solution {
    int i;
    public String decodeString(String s) {
        if(s == null || s.length() == 0)
            return s;
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
                StringBuilder parent =  new StringBuilder();
                for(int j = 0; j < num; j++)
                    parent.append(child);
                str.append(parent);
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