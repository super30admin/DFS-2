/* Problem2- Decode String */

//DFS Solution
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Here we will maintain two stacks 'nums' and 'strings'
// The number stacks stores number of times a future string(a string that is in upcming square brackets)
// needs to be processed at the top
// The string stack contains all the past strings have been processed. These past strings need to be concatenated
// with future strings to give out the resultant strings

class Solution {
    public String decodeString(String s) {
        //initialise string stack
        Stack<String> str = new Stack<>();
        //initialise nums stack
        Stack<Integer> nums = new Stack<>();
        //initially set nums and string to 0 and null
        int currNum = 0;
        String currStr = "";
        //iterate over the string
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNum = currNum*10 + c - '0';
            }
            //At the starting of square bracket, push the past strings in string stack
            //and num for future string in num stack
            else if(c == '['){
                nums.push(currNum);
                str.push(currStr);
                //again reset the nums and str to 0 and null
                currNum = 0;
                currStr = "";
            }
            //At the end of square bracket, process the past string
            else if(c == ']'){
                StringBuilder newStr = new StringBuilder();
                //popping the number from nums stack
                int time = nums.pop();
                for(int j = 0; j < time; j++){
                    newStr.append(currStr);
                }
                //now concatenate past string with new string
                currStr = str.pop() + newStr;
            }
            //otherwise if char is not a digit
            else {
                currStr += c;
            }       
        }
        return currStr;
    }
}