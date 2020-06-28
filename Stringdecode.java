//Time complexity:O(n)
//Space complexity:O(n)

class Solution {
    public String decodeString(String s) {
        if(s==null || s.length()==0){
            return s;
        }
        Stack<Integer> st1=new Stack();
        Stack<StringBuilder> st2=new Stack();
        int currnum=0;
        StringBuilder currstr=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                currnum=currnum*10 + c-'0';
            }
            else if(c=='['){
                st1.push(currnum);
                st2.push(currstr);
                currnum=0;
                currstr=new StringBuilder();
            }
            else if(c==']'){
                int times=st1.pop();
                StringBuilder sb=new StringBuilder();
                for(int k=0;k<times;k++){
                    sb.append(currstr);
                }
                currstr=st2.pop().append(sb);
            }
            else{
                currstr.append(c);
            }
        }
        return currstr.toString();
    }
}