// Time Complexity : O(output)
// Space Complexity : O(input)
// Did this code successfully run on Leetcode : yes
class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> currStack = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int num =0;
        for(int i =0; i< s.length(); i++){
            char c = s.charAt(i);
            if(c=='['){
                numStack.push(num);
                currStack.push(currStr);
                currStr = new StringBuilder();
                num =0;
                
            }else if(Character.isDigit(c)){
                num = num*10 + (c-'0');
                
            }else if(c==']'){
                int count = numStack.pop();
                StringBuilder sb = new StringBuilder();
                for(int k =0; k<count; k++){
                    sb.append(currStr);
                }
                StringBuilder parent = currStack.pop();
                currStr = parent.append(sb);
                
            }else{
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}