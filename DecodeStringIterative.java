// Time Complexity : O(n) where n is the length of final string
// Space Complexity : O(n) => For both the stack we will ~store n/2 elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
 Approach: This solution uses iteractive approach. We will use 2 stacks for for string and the 2nd will have the numbers. We have 2 variables num and curr. We will iterate over the string if a character is a number then multiply the num*10 + (charcater - '0'), if character is a char then append to curr, if '[' the push the curr and num to the stack and if ']' pop from the num stack and append the curr char that many times and then pop from the strStack and append to curr
 */
class Solution {
    public String decodeString(String s) {

        if(s.length() == 0 || s == null){
            return "";
        }
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int num = 0;

        for(int i =0; i<s.length(); i++){

            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10 + (c - '0'); //xing by 10 as in case if we have 2 continuous nunber i.e. 32
            }
            else if(c == '['){
                strStack.push(curr);
                numStack.push(num);
                curr = new StringBuilder();
                num = 0;
            }
            else if(c == ']'){
                int times = numStack.pop();
                StringBuilder newCurr = new StringBuilder();
                for(int j =0; j<times; j++){
                    newCurr.append(curr);
                }

                curr = strStack.pop().append(newCurr);
            }
            else{
                curr.append(c);
            }
        }

        return curr.toString();
    }
}