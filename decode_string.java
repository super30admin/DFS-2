//Time - O(n)
//Space - O(l)
class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch!=']'){
                st.push(ch);
            }
            else {
                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                StringBuilder sbno = new StringBuilder();
                while(!st.isEmpty() && st.peek() != '['){
                    sb = sb.append(st.pop());
                }
                for(int j=sb.length()-1;j>=0;j--){
                    sb2.append(sb.charAt(j));
                }
                st.pop();
                int sum = 0;
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    sbno = sbno.append(st.pop());
                }
                for(int j=sbno.length()-1;j>=0;j--){
                    char ch1 = sbno.charAt(j);
                    int n = ch1 - '0';
                    sum = sum*10 + n;
                }
                for(int k=0;k<sum;k++){
                    sb1.append(sb2);
                }
                for(int k=0;k<sb1.length();k++){
                    st.push(sb1.charAt(k));
                }
            }
        }
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sbfinal = new StringBuilder();
        while(!st.isEmpty()){
            sb3.append(st.pop());
        }
        for(int j=sb3.length()-1;j>=0;j--){
            sbfinal.append(sb3.charAt(j));
        }
        return sbfinal.toString();
    }
}
