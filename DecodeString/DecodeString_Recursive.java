/* Time Complexity : O(K) 
 *  K - depth of maximum nested bracket into all the numbers */
/* Space Complexity : O(h)
 *  h - height of the recursive stack */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

//Recursive solution

class Solution {
    int i;
    public String decodeString(String s) {
        int num = 0;
        StringBuilder currStr = new StringBuilder();
        while(i < s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                i++;
                num = num * 10 + c - '0';
            }else if(c == '['){
                i++;
                String childStr = decodeString(s);
                for(int k = 0; k < num; k++){
                    currStr.append(childStr);
                }
                num = 0;
            }else if(c == ']'){
                i++;
                return currStr.toString();
            }else{
                i++;
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}