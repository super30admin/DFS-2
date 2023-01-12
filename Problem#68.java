// Decode String

// Time Complexity : O(k), where k is the length of the output string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int currNum = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNum = currNum * 10 + c - '0';
            } else if(c == '['){
                strSt.push(currStr);
                numSt.push(currNum);
                currStr = new StringBuilder();
                currNum = 0;
            } else if(c == ']'){
                int count = numSt.pop();
                StringBuilder child = new StringBuilder();
                for(int j = 0; j < count; j++){
                    child.append(currStr);
                }
                StringBuilder parent = strSt.pop();
                currStr = parent.append(child);
            } else {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}
