// Time Complexity :O(n x k)
// Space Complexity :O(n x k)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
// maintain two stacks: one for string and another for number corresponding to inner string
// if character is digit: calculate number
// if character is alphabet: append to str
// if character is [: push to stack and refresh num and str
// if character is ]: pop and process it num times
class Solution {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        int currNum = 0;
        StringBuilder currStr = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNum = currNum * 10 + c - '0';
            }else if(c == '['){
                strSt.push(currStr);
                numSt.push(currNum);
                currNum = 0;
                currStr = new StringBuilder();
            }else if(c == ']'){
                int cnt = numSt.pop();
                StringBuilder prev = strSt.pop();
                for(int k=0; k<cnt; k++){
                    prev.append(currStr);
                }
                currStr = prev;
            }else{
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}
