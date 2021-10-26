//Time complexity:- o(n^2);
//space complexity:-0(1);
//Did it run on leetcode:-Yes;
// what problems you faced while doing this sum?:- some errors initially.
//your code with explanation:- iterating every charecter and whenever we got [ calling recursively and between [ to ] building a string.

class Solution {
    int i=0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        
        while (i < s.length()) {
            char c = s.charAt(i);
            i++;
            
            if (c == ']') { 
                break;
            }
            
            if (Character.isLetter(c)) { 
                sb.append(c);
                continue;
            }
            
            if (c == '[') {
                String tmp = decodeString(s);
                for (int j = 0; j < count; j++) {
                    sb.append(tmp);
                }
                count = 0;
            } else {
                count = count * 10 + c - '0'; 
            }
            
        }
        return sb.toString();
        
        
    }
}
