// Time Complexity : O(product of all (num*length of currStr))
// Space Complexity : O(len(s))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : process string in dfs fashion. Main 2 stacks and 2 variables, one for numbers and one for strings.
// Traverse string from left to right, if the current charcter is number, update the num variable, if currChar = character,
//append it to string variable. If currChar =='[' push both num and currStr variables to stack and reset them. If currChar ']',
// pop from both stacks, repeat the currStr the number popped from numStack and append it to string popped from string stack
//Lastly the currentString variable.
class Solution {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<Integer>();
        Stack<StringBuilder> strSt = new Stack<StringBuilder>();
        int num=0;
        StringBuilder currStr = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(Character.isDigit(curr)){
                num = num*10 + (curr-'0'); 
            }
            else if(curr == '['){
                numSt.push(num);
                strSt.push(currStr);
                num=0;
                currStr = new StringBuilder();
            }
            else if(curr == ']'){
                int numPopped = numSt.pop();
                StringBuilder strPopped = strSt.pop();
                StringBuilder decoded = new StringBuilder();
                for(int k=0;k<numPopped;k++){
                    decoded.append(currStr);
                }
                currStr = strPopped.append(decoded);
            }
            else{
                currStr.append(curr);
            }
        }
        return currStr.toString();
    }
}