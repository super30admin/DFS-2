//Time Complexity=O(curr.length)
//Space Complexity=O(curr.length)
public class DecodeStringRecursive {
    int i;
    public String decodeString(String s) {
        StringBuilder currStr=new StringBuilder();
        int num=0;
        while(i<s.length()){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+c-'0';
                i++;
            }else if(c=='['){
                i++;
                String decode=decodeString(s);
                for(int j=0;j<num;j++){
                    currStr.append(decode);
                }
                num=0;
            }else if(c==']'){
                i++;
                return currStr.toString();
            }else{
                currStr.append(c);
                i++;
            }
        }
        return currStr.toString();
    }
}
