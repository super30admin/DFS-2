// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    int i=0;
    public String decodeString(String s) {
         Stack<Integer> numStack = new Stack<>();
         Stack<String> strStack = new Stack<>();
        
        int currNum = 0;
        String currStr = "";
        
        for(;i<s.length();i++) {
            char temp = s.charAt(i);
            
            if(Character.isDigit(temp)) {
                currNum = currNum*10+(temp - '0');
            }
            else if(temp == '[') {
                numStack.push(currNum);
                strStack.push(currStr);
                
                currNum = 0;
                currStr = "";
            }
            else if(temp == ']') {
                int n = numStack.pop();
                String t = "";
                for(int j=0;j<n;j++) {
                    t = t + currStr;
                }
                currStr = strStack.pop()+t;
            }
            else {
                currStr = currStr+temp;
            }
        }
        return currStr;
    }
}