class Solution {
    int i = 0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int num=0;
        while(i<s.length()){
            if(Character.isDigit(s.charAt(i))){
                num = num*10 + (s.charAt(i)-'0');
                i++;
            }
            else if(s.charAt(i)=='['){
                i++;
                String inner = decodeString(s);
                // inner = new StringBuilder();
                for(int i=0;i<num;i++){
                    sb.append(inner);
                }
                // inner.append(sb);
                num=0;
            }
            else if(s.charAt(i)==']'){
                i++;
                break;
                // return inner.toString();
            }
            else{
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}


//Time complexity : O(N)
//Space complexity : O(N)
