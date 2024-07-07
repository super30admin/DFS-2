// Time Complexity : O(n) where n is the length of final string
// Space Complexity : O(n) => Recursive stack. We initiate recursive call when we encounter '[' which is n times
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Had initialized global variable i = 0 inside decodeString() resulting in StackOverflowError

/*
 Approach: This solution uses recursive approach. We have 2 variables num and curr and a global variable i. We will iterate  until i is less than length of s, if a character is a number then multiply the num*10 + (charcater - '0') & increment i, if character is a char then append to curr & increment i, if '[' then increment i and call decodeString(s) and then run for loop num times and append output of decodeString(s) to newStr and then finally append it to curr and num = 0 and if ']' increment i and return curr string.
 */
class Solution {
    int i;
    public String decodeString(String s) {

        if(s.length() == 0 || s == null){
            return "";
        }

        int num = 0;
        StringBuilder curr = new StringBuilder();

        while(i < s.length()){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                i++;
                num = num*10 + (c - '0');
            }
            else if(c == '['){
                i++;
                String decoded = decodeString(s);
                StringBuilder newCurr = new StringBuilder();
                for(int j =0; j<num; j++){
                    newCurr.append(decoded);
                }

                curr.append(newCurr);
                num = 0;
            }
            else if(c == ']'){
                i++;
                return curr.toString();
            }
            else{
                i++;
                curr.append(c);
            }
        }

        return curr.toString();
    }
}