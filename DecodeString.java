// Approach 1: Using stacks
// Time Complexity : O(length of output)
// Space Complexity : O(length of output)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We will use two variables curStr, curNum and two stacks strSt, numSt
// We can then iterate over the string. If it is a character/digit update curSr/curNum
// If it is '[', abandon curStr and curNum in the stack and reset the two var
// If it is '[', update curStr based on stack.pop values

class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> strSt = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        int curNum = 0;
        StringBuilder curStr = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curNum = curNum*10 + c-'0';
            }
            else if(Character.isAlphabetic(c)){
                curStr.append(c);
            }
            else if(c=='['){
                numSt.push(curNum);
                strSt.push(curStr);
                curNum = 0;
                curStr = new StringBuilder();
            }
            else if(c==']'){
                int repeat = numSt.pop();
                StringBuilder decoded = new StringBuilder();
                for(int j=0; j<repeat; j++){
                    decoded.append(curStr);
                }
                StringBuilder pre = strSt.pop();
                curStr = pre.append(decoded);
            }
        }
        return curStr.toString();
    }
}

//Approach 2: Recursion
// Time Complexity : O(length of output)
// Space Complexity : O(length of output)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Same as approach 1 but we are using recursion stack in the place of external stacks
// By maintaining global var i while traversing string, we can call decode on same string, no need to create substring

class Solution {
    int i=0;
    public String decodeString(String s) {
        int curNum = 0;
        StringBuilder curStr = new StringBuilder();
        while(i<s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curNum = curNum*10 + c-'0';
                i++;
            }
            else if(Character.isAlphabetic(c)){
                curStr.append(c);
                i++;
            }
            else if(c=='['){
                i++;
                String child = decodeString(s);
                for(int i=0;i<curNum;i++){
                    curStr.append(child);
                }
                curNum = 0;
                i++;
            }
            else if(c==']'){
                return curStr.toString();
            }
        }
        return curStr.toString();
    }
}