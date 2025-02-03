import java.util.Stack;
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//Push in stack and determine behaviour based on character in string
class DecodeString {
    public String decodeString(String s) {
        if(s==null||s.length()==0){
            return s;
        }
        Stack<String> stack= new Stack<>();
        int accumalatedNumber = 0;
        StringBuilder accumalatedsubString = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                accumalatedNumber=accumalatedNumber*10+(c-'0');
            }
            else if(c=='['){
                stack.push(String.valueOf(accumalatedNumber));
                stack.push(accumalatedsubString.toString());
                accumalatedsubString = new StringBuilder();
                accumalatedNumber = 0;
            }
            else if(c==']'){
                String rString = stack.pop();
                Integer rNumber = Integer.parseInt(stack.pop());
                StringBuilder newString = new StringBuilder();
                for(int j=0;j<rNumber;j++){
                    newString.append(accumalatedsubString);
                }
                accumalatedsubString = new StringBuilder(rString).append(newString);
            }
            else {
                accumalatedsubString.append(c);
            }
        }
        return accumalatedsubString.toString();
    }
}