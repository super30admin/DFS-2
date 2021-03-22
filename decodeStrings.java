// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
-> Have two stacks(strings and numbers). If the char is a digit then append it to currNum.
-> if the char is an opening brace, add the currNum to numStack and the currStr to StrStack.
-> and assign the currNum to 0 and currStr to "".
-> if the char is a closing brace, pop the numStack and then append the currStr to the tempString for popped times.
-> and add the poppedStr from StrStack to temp and assign it to currStr
-> else append the char to currStr and return the currStr since we are manipulating that
*/

// Your code here along with comments explaining your approach
class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        
        Stack<Integer> sNum = new Stack<>();
        Stack<String> sStr = new Stack<>();
        
        String currStr = "";
        int currNum = 0;
        
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                currNum = currNum*10 + (ch-'0');
            }
            else if(ch == '['){
                sNum.add(currNum);
                sStr.add(currStr);
                
                currNum = 0;
                currStr = "";
            }
            else if(ch == ']'){
                int popped = sNum.pop();
                String temp = "";
                
                for(int i =0;i<popped;i++){
                    temp += currStr;
                }
                currStr = sStr.pop()+temp;
            }
            else{
                //alphabet
                currStr += ch;
            }
            
        }
        return currStr;
    }
}