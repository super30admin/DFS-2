//Time : O(n)
//Space : O(n)

class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        
        Stack<StringBuilder> st = new Stack<>();
        Stack<Integer> num = new Stack<>();
        StringBuilder currStrng = new StringBuilder();
        int n = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                n = n*10 + (c-'0');    
            }else if(c == '['){
                num.push(n);
                st.push(currStrng);
                currStrng = new StringBuilder();
                n = 0;
            }else if(c == ']'){
                StringBuilder sb = st.pop();
                for(int j = num.pop(); j > 0; j--){
                    sb.append(currStrng);
                }
                currStrng = sb;
            }else{
                currStrng.append(c);    
            }
        }
        return currStrng.toString();
    }
}