// Time Complexity : O(N) where n is the length of the string
// Space Complexity : O(N) where n is the length of the string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        
        Stack<Integer> counts = new Stack();
        Stack<String> result = new Stack();
        String res = "";
        int index = 0;
        
        while(index < s.length()){
            if(Character.isDigit(s.charAt(index))){
                int count = 0;
                while (Character.isDigit(s.charAt(index))){
                   count = 10  * count + (s.charAt(index) - '0');
                    index += 1; 
                }
                counts.push(count);
            }else if(s.charAt(index) == '['){
                result.push(res);
                res = "";
                index += 1;
            }else if(s.charAt(index) == ']'){
                String temp = result.pop(); 
                int count = counts.pop();
                for(int i = 0; i < count; i++){
                    temp += res;
                }
                res = temp;
                index += 1;
            }else{
                res += s.charAt(index);
                index += 1;
            }
        }
        return res;
    }
}

<-----Recursion---->
Time and space both O(n)
class Solution {
    int pos = 0;
    public String decodeString(String s) {
        return decode(s);
    }
    private String decode(String s) {
        if(s == null || s.length() == 0) return "";
        StringBuilder sub = new StringBuilder();
        while(pos < s.length()) {
            char c = s.charAt(pos);
            if(Character.isLetter(c)) {
                sub.append(c);
                pos++;
            }
            else if(Character.isDigit(c)) {
                int cnt = 0;
                //might be more than one digit number 
                while(Character.isDigit(c)) {
                    cnt = cnt * 10 + c - '0';
                    pos++;
                    c = s.charAt(pos);
                }
                pos++;
                String dup = decode(s);
                while(cnt > 0){
                    sub.append(dup);
                    cnt--;
                }
            }
            else if(c == ']') {
                pos++;
                return sub.toString();
            }
        }
        return sub.toString();   
    }
}
