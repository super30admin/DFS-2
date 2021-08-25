/* Time Complexity :  O(k*N)
   Space Complexity : O(k*N)  
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
*/
class Solution {
    public String decodeString(String s) {
        //use two stacks - one stack to store number, other to store characters
        Stack<StringBuilder> strStack = new Stack<>(); 
        Stack<Integer> numStack = new Stack<>();
        int num=0;
        StringBuilder st = new StringBuilder(); //result
        //traverse the string. 4 cases - number case, character case, [ case, ] case
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>=48 && s.charAt(i) <=57){
                //number case, find the total number and keep storing
                num = (num * 10 ) + (s.charAt(i) - '0') ;
            }
            else if(s.charAt(i)=='[')
            {
                //push the num and characters till now to stacks
                //make the string emmpty and num to 0
                strStack.push(st);
                numStack.push(num);
                num=0;
                st=new StringBuilder();
            }
            else if(s.charAt(i)==']'){
                //pop out the latest values from stacks, string is repeated and concatentate with popped string from stack to this.
                StringBuilder curStr = new StringBuilder();
                int curNum = numStack.pop();
                for(int j=0;j<curNum;j++)
                {
                    curStr.append(st);
                }
                st = strStack.pop().append(curStr);
                
            }
            else
            {
                //character append to string
                st.append(s.charAt(i));
            }
        }
        return st.toString();
    }
}