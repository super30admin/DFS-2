// Time Complexity : O(Max(k*n)) where k is a number and n is the length of string
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
one stack to keep track numbers and other one to track  string formed so far
2 values to store nums and string, whenever we found "[" push the nums and string to their respective stacks
if ] --> then pop the number and create a string number of times as popped number
append it to the parent string formed so far
 */
class Solution {
    public String decodeString(String s) {
        if(s.length()==0) return s;
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        int num=0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            //number
            if(Character.isDigit(c)){
                num = 10*num+c-'0';
            }
            // [
            else if(c=='['){
                //push num and string to stacks
                numStack.push(num);
                strStack.push(sb);
                num=0;
                sb= new StringBuilder();
            }
            // ]
            else if(c==']'){
                //pop the number
                int times = numStack.pop();
                StringBuilder curr = new StringBuilder();
                //build the string
                for(int k=0; k<times; k++){
                    curr.append(sb);
                }
                StringBuilder parent = strStack.pop();
                sb = parent.append(curr);
            } else{
                // character
                sb.append(c);
            }
        }
        return sb.toString();
    }
}