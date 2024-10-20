class Solution {
    int i;
    public String decodeString(String s) {
        StringBuilder curr=new StringBuilder(s);
        StringBuilder decoded = helper(curr);

        return decoded.toString();
    }
    private StringBuilder helper(StringBuilder s){
        int num=0;
        StringBuilder curr=new StringBuilder();

        while(i<s.length()){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+(c-'0');
                i++;
            }
            else if(c=='['){
                i++;
                StringBuilder decoded = helper(s);
                for(int j=0;j<num;j++){
                    curr.append(decoded);
                }
                i++;
                num=0;
                continue;
            }
            else if(c==']'){
                return curr;
            }
            else{
                curr.append(c);
                i++;
                continue;
            }
        }
        return curr;
    }
}
