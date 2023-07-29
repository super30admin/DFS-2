// Time Complexity : O(maxK⋅n), where maxK is the maximum value of k and n is the length of a given string s
// Space Complexity : O(M+N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    public String decodeString(String s) {
        Stack<Integer> numstack = new Stack<>();
        Stack<StringBuilder> strstack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int nums =0;
        for(int i =0; i<s.length();i++){
            Character c = s.charAt(i);
            if(Character.isDigit(c)){
                nums = nums*10+c-'0';
            }
            else if(c == '['){
                strstack.push(curr);
                numstack.push(nums);
                curr = new StringBuilder();
                nums = 0;
            }
            else if(c == ']'){
                int k = numstack.pop();
                StringBuilder parent = strstack.pop();
                for(int j = 0; j<k;j++){
                    parent.append(curr);
                }
                curr = parent;
            }
            else{
                curr.append(c);
            }
        }
        return curr.toString();
    }
}