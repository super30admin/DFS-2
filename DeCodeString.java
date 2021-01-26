/**
Input: s = "3[a]2[bc]"
Output: "aaabcbc"

possible characters 
    opening brace
    closing brace 
    an alphabet
    a number
    
Collabedit: http://collabedit.com/edut9

**/
class Solution 
{
    int idx = 0;
    
    public String decodeString(String s) {
        int n = s.length();
        if(idx>=n) return "";
        
        x
        StringBuilder sb = new StringBuilder();
        while(idx<n) {
            char ch = s.charAt(idx);
            if(Character.isAlphabetic(ch)) sb.append(ch);
            else if(Character.isDigit(ch)) {
                int count = 0;
                while(idx<n && s.charAt(idx)!='[') {
                    int currNum = s.charAt(idx)-'0';
                    count = 10*count+currNum;
                    idx++;
                }
                String next = decodeString(s);
                while(count>0) {
                    sb.append(next);count--;
                }
            }
            else if(ch==']') break;
            idx++;
        }
        return sb.toString();
    }
}