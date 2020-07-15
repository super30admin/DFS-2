/**
 * Time: O(n*k) n-length of the gvn string and k-largest number in the given string
 * Space: O(n) stk size
 */
class Solution {
    class Code{
        int num;
        String str;
        Code(int n,String s){
            num = n;
            str = s;
        }
    }
    public String decodeString(String s) {
        Stack<Code> stk = new Stack();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                cnt = (cnt*10)+s.charAt(i)-'0';
            }
            else if(s.charAt(i) == '['){
                stk.push(new Code(cnt,sb.toString()));
                cnt = 0;
                sb = new StringBuilder();
            }
            else if(s.charAt(i) == ']'){
                Code c = stk.pop();
                StringBuilder rep = new StringBuilder();
                rep.append(c.str);
                for(int k=0;k<c.num;k++){
                    rep.append(sb);
                }
                sb = rep;
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}