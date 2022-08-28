// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// The problem can be solved using two stacks or solved recurrsively, I have used 2 stack method where one stack is storing character value and the other stack is storing the number of time the character should be decoded. We need to iterate through the string and check at each character 4 conditions, if the charater is digit convert the digit into ascii value, then if the charater is opening square bracket then push the number character at the numstack and push the alphabet character at the string stack, if the character is closing bracket then decode the string else just push the character into the current string 



class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> strSt = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int currNum = 0;
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNum = currNum * 10 + c - '0';
            }else if(c=='['){
                numSt.push(currNum);
                strSt.push(currStr);
                currStr = new StringBuilder();
                currNum = 0;
            }else if(c==']'){
                // decoding the string
                int times = numSt.pop();
                StringBuilder sb = new StringBuilder();
                for(int k=0; k<times; k++){
                    sb.append(currStr);
                }
                currStr = strSt.pop().append(sb);
            }else{
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}