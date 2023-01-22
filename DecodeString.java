// Time Complexity : O(length of output string)
// Space Complexity : O(length of output string)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//iterative
//in this approach we take two stacks to store the string and number. We first take an empty string as currStr and 0 as current number. We iterate over the string
//and if we find a number we uodate the current number to that number. If we find a character we append it to the currSTr. if we find a opening bracket
//we push the currstring and number to the stack and we reset the curr string and number. If we find the closing bracket we pop the number on top and we append the 
//current string that number of times and pop the string on the top of string stack and append that and update the curr string since that will be the parent.
class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> strSt = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int currNum = 0;
        for(int i =0 ;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNum = currNum*10 +c - '0';
            }else if(c == '['){
                strSt.push(currStr);
                numSt.push(currNum);
                currStr = new StringBuilder();
                currNum = 0;
            }else if(c == ']'){
                int count = numSt.pop();
                StringBuilder inter = new StringBuilder();
                for(int j =0 ;j<count;j++){
                    inter.append(currStr);
                }
                StringBuilder parent = strSt.pop();
                currStr = parent.append(inter);
            }else{
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}

//dfs
class Solution {
    int i =0;
    public String decodeString(String s) {
        StringBuilder currStr = new StringBuilder();
        int currNum = 0;
        while(i<s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNum = currNum*10 +c - '0';
                i++;
            }else if(c == '['){
                i++;
                String decode = decodeString(s);
                for(int k =0; k<currNum;k++){
                    currStr = currStr.append(decode);
                }
                currNum = 0;
                i++;
            }else if(c == ']'){
                return currStr.toString();
            }else{
                currStr.append(c);
                i++;
            }
        }
        return currStr.toString();
    }
}