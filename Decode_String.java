// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    int i;
    public String decodeString(String s) {
        if(s==null || s.length() == 0){
            return "";
        }
        int num = 0;
        StringBuilder curr = new StringBuilder();
        while(i<s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                i++;
                num = num*10 + (c-'0');
            }
            else if(c == '['){
                i++;
                String decoded = decodeString(s); // push
                StringBuilder newStr = new StringBuilder();
                for(int j = 0; j<num;j++){
                    newStr.append(decoded);
                }
                curr.append(newStr);
                num = 0;
            }
            else if(c == ']'){
                i++;
                return curr.toString(); //pop
            }
            else{
                i++;
                curr.append(c);
            }
        }
        return curr.toString();
    }
}