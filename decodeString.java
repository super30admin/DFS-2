// Time Complexity : O(n)
// Space Complexity : O(n)
class Solution {
    int idx;
    public String decodeString(String s) {
        int currNum = 0;
        StringBuilder currStr = new StringBuilder();
        while(idx<s.length()){
            char c = s.charAt(idx);
            if(Character.isDigit(c)){
                currNum=currNum*10+(c-'0');
                idx++;
            }else if(c=='['){
                idx++;
                String baby = decodeString(s);
                for(int k=0;k<currNum;k++){
                    currStr.append(baby);
                }
                currNum=0;
            }else if(c==']'){
                idx++;
                return currStr.toString();
            }else{
                currStr.append(c);
                idx++;
            }
        }
        return currStr.toString();
    }
}