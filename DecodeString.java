// Time Complexity : O(N), N is length of output or decoded string
// Space Complexity : O(m + n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    public String decodeString(String s) {
        
        if(s == null || s.length() == 0) return s;
        
        int num = 0;
        StringBuilder currString = new StringBuilder();
        Stack<Integer> nums = new Stack<>();
        Stack<StringBuilder> strings = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            
            char c = s.charAt(i);
            
            if(Character.isDigit(c)) {
                num = num * 10 + c - '0';
                
            }
            
            else if(c == '[') {
                nums.push(num);
                strings.push(currString);
                num = 0;
                currString = new StringBuilder();
            }
            
            else if(c == ']') {
                int times = nums.pop();
                StringBuilder newString = new StringBuilder();
                for(int j = 0; j < times; j++) {
                    newString.append(currString);
                }
                currString = strings.pop().append(newString);
            }
            
            else {
                currString.append(c);
            }
        }
        return currString.toString();
    }
}