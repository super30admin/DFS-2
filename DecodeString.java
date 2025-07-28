//Time Complexity : O(n)
//Space Complexity: O(n)
class Solution {
    int i =0;
    public String decodeString(String s) {
        int num = 0;
        StringBuilder currStr = new StringBuilder();
        int n = s.length();
        while(i < n){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                num = num*10 + c - '0';
                i++;
            } else if(c == '['){
                i++;
                String child = decodeString(s);
                StringBuilder decoded = new StringBuilder();
                for(int k = 0; k < num; k++){
                    decoded.append(child);
                }
                currStr.append(decoded);
                num =0;
            } else if(c == ']'){
                i++;
                return currStr.toString();
            }else {
                currStr.append(c);
                i++;
            }

        }
        return currStr.toString();
    }
}
