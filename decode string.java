// Time Complexity : O(n x max(k)) n = length of string k = number of times we have to repeat a decoded string
// Space Complexity : O(n) n - length of string
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public String decodeString(String s) {
        //edge
        if(s == null || s.length() == 0) return s;
        //create botha num and str stack
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        //create a current string 
        StringBuilder curString = new StringBuilder();
        //create current num
        int curNum = 0;
        //start a for loop that iterates through the given string to decode
        for(int i = 0; i < s.length(); i++){
            //take the current character
            char ch = s.charAt(i);
            //if your character is a digit multiply it by 10 then add the digit and update the current num (we multiply by 10 incase it is a double digit)
            if(Character.isDigit(ch)){
                curNum = curNum * 10 + ch - '0';
            }
            //if it is an opening bracket put the curNum and curString into their stacks respectively and set the curNum and curString back to 0 and " "
            else if(ch == '['){
                numStack.push(curNum);
                stringStack.push(curString);
                curNum = 0;
                curString = new StringBuilder();
            }
            //if it is a closing bracket pop the curNum from the stack (that is how many times we will repeat the current string)
            else if(ch == ']'){
                int repeat = numStack.pop();
                StringBuilder newString = new StringBuilder();
                //start a for loop that will create a new string that will appened curString (repeat) amount of times
                for(int j = 0; j < repeat; j++){
                    newString.append(curString);
                }
                //now pop the parent fron the stringStack because we will appened the newSting (the decoded iner brackets) with its parent outside the bracket
                //for example a2[d] would be newString = dd and then after appneding it would be add
                curString = stringStack.pop().append(newString);
            }
            //if it is a letter then just add it to the curString
            else{
                curString.append(ch);
            }
        }
        //just change StringBuilder to String and then return decoded whole string
        return curString.toString();
    }
}