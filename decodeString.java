// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : its difficult to come up the logic
// Your code here along with comments explaining your approach

class Solution {
    public String decodeString(String s) {
        
        StringBuilder currString = new StringBuilder();
        Stack<Integer> nums = new Stack();
        Stack<StringBuilder> str = new Stack();
        
        int num = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            }
            else if(ch == '['){
                nums.push(num);
                num = 0;
                str.push(currString);
                currString = new StringBuilder();
            }
            else if(ch == ']') {
                int times = nums.pop();
                StringBuilder newString = new StringBuilder();
                for(int j = 0; j < times; j++) {
                    newString.append(currString);
                }
                currString = str.pop().append(newString);
            }
            else{
                currString.append(ch);
            }
        }
        
        return currString.toString();
        
    }
}