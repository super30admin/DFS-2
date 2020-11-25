// Time Complexity :  O(maxK⋅n) no of elements
// Space Complexity : O(digits + chars) - worst case stack adding all elements
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<Integer>(); 
        Stack<StringBuilder> strStack = new Stack<StringBuilder>();
        int number = 0;
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        if(s == null || n == 0) return "";
        for(int i = 0; i < n; i++){
            //System.out.println(s.charAt(i));
            if(s.charAt(i) == '['){
                numStack.push(number);
                strStack.push(sb);
                sb = new StringBuilder();
                number = 0;
            }
            else if(Character.isDigit(s.charAt(i))){
                number = number * 10 + (s.charAt(i) - '0');
            }else if(s.charAt(i) == ']'){
                //decode
                //pop from numstack and multiply with curr string
                StringBuilder decoded = strStack.pop();
                int times = numStack.pop();
                for(int count = 0; count < times; count++){
                    decoded.append(sb);
                }
                sb = decoded;
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
  
}