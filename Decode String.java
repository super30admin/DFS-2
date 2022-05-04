// Time Complexity : O(n) where n is the length of the resultant string.
// Space Complexity : O(d) where d is the depth of the nesting. or the number of [ in the string
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> str = new Stack<>();
        Stack<Integer> num = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int currNum = 0;
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNum = currNum*10+c-'0';
            }
            else if(c=='['){
                num.push(currNum);
                currNum = 0;
                str.push(currStr);
                currStr = new StringBuilder();
            }
            else if(c==']'){
                int times = num.pop();
                StringBuilder newStr = new StringBuilder();
                for(int j =0;j<times;j++){
                    newStr.append(currStr);
                }
                currStr = str.pop().append(newStr);
            }
            else{
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}