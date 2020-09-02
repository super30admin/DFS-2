// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yeah I had to draw the stacks on white board


// Your code here along with comments explaining your approach
//Iterative solution

class Solution {
    // s = "3[a]2[bc]"
    //      *
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return s;
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        int currNum = 0; StringBuilder currStr = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                //c - '0' is converting char into ascii value
                // System.out.println(c - '0');
                currNum = currNum * 10 + c - '0';
            } else if(c == '['){
                numStack.push(currNum);
                strStack.push(currStr);
                currNum = 0;
                currStr = new StringBuilder();
            } else if(c == ']'){
                int precedingNum = numStack.pop();
                StringBuilder expandedStr = new StringBuilder();
                for(int j = 0 ; j < precedingNum; j++){
                    expandedStr.append(currStr);
                }
                //resetting currStr by prepending previous string
                //which was on the top of the stack with the
                //expanded string
                //now this currStr will be pushed on the top of the
                //stack once i hits another '['
                currStr = strStack.pop().append(expandedStr);
                currNum = 0;

            } else {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n) space of recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes I had to watch video for clues. I have to work harder on recursion.


// Your code here along with comments explaining your approach
//Recursive solution

class Solution {
    // s = "3[a2[c]]"
    //      *
    int i = 0;
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return s;
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        int num = 0; StringBuilder result = new StringBuilder();
        while(i < s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                //c - '0' is converting char into ascii value
                num = num * 10 + c - '0';
                i++;
            } else if(c == '['){
                i++;
		//call the recursion on the inner string
                String inner = decodeString(s);
		//append it to curr result
                for(int k = 0; k < num; k++){
                    result.append(inner);
                }
		//reset it to 0 after using it
                num = 0;
            } else if(c == ']'){
                i++;
		//return the result to recursion for next use
                return result.toString();
            } else {
                i++;
		//keep appending the alphabets
                result.append(c);
            }
        }
        return result.toString();
    }
}
