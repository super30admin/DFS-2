class Solution {
    private int i;
    public String decodeString(String s) {
        this.i =0;
        return a(s).toString();
    }
    private StringBuilder a(String s){
        StringBuilder r = new StringBuilder();
        int n = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            ++i;
            if(Character.isDigit(c)){
                n = n*10+(c-'0');
            }else if(c == '['){
               StringBuilder sr = a(s);
               while(n>0){
                   r.append(sr);
                   --n;
               }
            }else if(c == ']'){
                return r;
            }else{
                r.append(c);
            }
        }
return r;
    }
}
//tc=O(p*l)
//sc=O(p*l)
