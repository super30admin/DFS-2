// Time Complexity : O(n) where n is the length of the input string s
// Space Complexity : O(n) using stack to store the operands of the string 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

class Solution {
    public String decodeString(String s) {
        Stack<Integer> stNum = new Stack<>();
        Stack<String> stStr = new Stack<>();
        String str = "";
        int i=0;
        while(i<s.length()){
            if(Character.isDigit(s.charAt(i))){
                int num=0;
                while(Character.isDigit(s.charAt(i))){
                    num = num *10+(s.charAt(i)-'0');
                    i++;
                }
                stNum.push(num);
            }
            else if(s.charAt(i) == ']'){
                StringBuilder sb = new StringBuilder(stStr.pop());
                int repeat = stNum.pop();
                for(int j = 0; j < repeat; j++) {
                    sb.append(str);
                }
                str = sb.toString();
                i++;
                
            }
            else if(s.charAt(i) == '['){
                stStr.push(str);
                str ="";
                i++;
            }
            else{
                str += s.charAt(i); 
                i++;
            }
        }
        return str;
    }
}
