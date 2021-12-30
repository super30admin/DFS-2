// Time Complexity :O(maxK*n) where maxK is the maximum value of k and n is length of the string
// Space Complexity :O(m +  n) m is no.of letters and n is the ni.of digits
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0)
            return "";
        Stack<StringBuilder> stringStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            else if(c == '['){
                stringStack.push(sb);
                numStack.push(num);
                num = 0;
                sb = new StringBuilder();
            }
            else if(c == ']'){
                int count = numStack.pop();
                StringBuilder sb2 = new StringBuilder();
                while(count-- > 0){
                    sb2.append(sb);
                   // count--;
                }
                sb = stringStack.pop().append(sb2);
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
