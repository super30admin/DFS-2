// Time Complexity : O(N) - As we traverse through the whole String
// Space Complexity : O(N) - As we use a String Builder
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int pos = 0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        String num = "";
        for(int i  = pos;i < s.length();i++){
            if(s.charAt(i) != '[' && s.charAt(i) != ']' && !Character.isDigit(s.charAt(i)) ){
                sb.append(s.charAt(i));
            }
            if(Character.isDigit(s.charAt(i))){
                num += s.charAt(i);
            }
            else if(s.charAt(i) == '['){
                pos = i + 1;
                String next = decodeString(s);
                for(int j = Integer.valueOf(num);j > 0;j--){
                    sb.append(next);
                }
                num = "";
                i = pos;
            }
            else if(s.charAt(i) == ']'){
                pos = i;
                return sb.toString();
            }
        }
        return sb.toString();
    }
}
// Your code here along with comments explaining your approach