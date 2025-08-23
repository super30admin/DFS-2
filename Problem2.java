// Time Complexity : O(N*K), where N is the length of the input string and K is maximum repeat count
// Space Complexity : O(N*K)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// I used two stacks to keep track of the current number and the current string while decoding the input string.
// Traverse the string and if we encounter a digit, we build the current number.
// If we encounter a '[', we push the current number and string onto their respective stacks and reset them.
// If we encounter a ']', we pop from the stacks and repeat the current string as needed and 
// append it to the previous string.else we append the current character to the current string.

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStk=new Stack<>();
        Stack<StringBuilder> strStk=new Stack<>();

        int currNum=0;
        StringBuilder currStr=new StringBuilder();

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                currNum=currNum*10+c-'0';
            }else if(c=='['){
                numStk.push(currNum);
                strStk.push(currStr);
                
                currNum=0;
                currStr=new StringBuilder();
            }else if(c==']'){
                int cnt=numStk.pop();
                StringBuilder temp=strStk.pop();
                
                for(int k=0;k<cnt;k++){
                    temp.append(currStr);
                }
                currStr=temp;
            }else{
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}