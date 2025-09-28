// Time Complexity : O(nxk)
// Space Complexity : O(nxk)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    int i = 0;
    public String decodeString(String s) {

        int currNum = 0;
        StringBuilder currStr = new StringBuilder();

        while(i < s.length()){
            char c = s.charAt(i);
            i++;

            if(Character.isDigit(c)){
                currNum = currNum * 10 + c - '0';
            }else if(c == '['){
                String baby = decodeString(s);
                for(int k=0; k<currNum; k++){
                    currStr.append(baby);
                }

                currNum = 0;

            }else if(c == ']'){
                return currStr.toString();
            }else{
                currStr.append(c);
            }
        }

        return currStr.toString();
    }
}
