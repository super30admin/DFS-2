// Time Complexity : O(kn)
// Space Complexity : O(kn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0)
            return s;
        
        int num = 0;
        StringBuilder currStr = new StringBuilder();
        
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        
        for(int i=0; i< s.length(); i++){
                char c = s.charAt(i);
        
        
        //digit
        if(Character.isDigit(c)){
            num = num * 10 + c - '0';
        }
        
        //[
        else if(c == '['){
            //push num and string to stacks
            numStack.push(num);
            strStack.push(currStr);
            //reset both
            num = 0;
            currStr = new StringBuilder();
        }
        //]
        else if(c==']'){
            //pop num
            int  times = numStack.pop();
            StringBuilder newStr = new StringBuilder();
            //build the string
            for(int k=0; k<times; k++){
                newStr.append(currStr);
            }
            //combine with the parent
            StringBuilder parent = strStack.pop();
            currStr = parent.append(newStr);
        }
        
        //character
        else {
            currStr.append(c);
        }
        }
        return currStr.toString();
        
    }
}