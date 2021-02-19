// Time Complexity : O(n+k) k is sum of numbers
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
public class Solution {
    public String decodeString(String s) {
        
        Stack<String> str = new Stack();
        Stack<Integer> num = new Stack();
        
        int currNum=0;
        String currStr="";
        
        for(int i = 0;i<s.length();i++) {
            
            char c = s.charAt(i);
            
            // if digit calculate current number
            if(Character.isDigit(c)){
                currNum = currNum * 10 + c - '0';
            }
            // if '[' push current values
            else if (c == '[') {
                num.push(currNum);
                str.push(currStr);
                currNum = 0;
                currStr = "";
            } 
            // if closing bracket pop and build string
            else if ( c == ']'){
                int tmp = num.pop();
                StringBuilder newStr = new StringBuilder();
                for(int j = 0;j < tmp; j++){
                     newStr.append(currStr);
                }
                currStr = str.pop();
                currStr += newStr;
            } else {
                currStr += c;
            }
            
        }
        return currStr;
    }
}
