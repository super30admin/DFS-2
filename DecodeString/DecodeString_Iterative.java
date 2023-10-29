/* Time Complexity : O(K) 
 *  K - depth of maximum nested bracket into all the numbers */
/* Space Complexity : O(k)
 *  k - depth of maximum nested bracket */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

//Iterative solution

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        int num = 0;
        StringBuilder currStr = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }else if(c == '['){
                //push the parent to stack and reset the num and currStr
                numSt.push(num);
                strSt.push(currStr);
                num = 0;
                currStr = new StringBuilder();
            }else if(c == ']'){
                //Repeat currStr numSt.pop() times and append it to strSt.pop()
                int count = numSt.pop();
                StringBuilder childStr = new StringBuilder();
                for(int k = 0; k < count; k++){
                    childStr.append(currStr);
                }
                currStr = strSt.pop().append(childStr);
            }else{
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}