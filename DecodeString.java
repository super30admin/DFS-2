
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
// 	

// Your code here along with comments explaining your approach

class Solution {
    public String decodeString(String s) {
          Stack<Integer> countstack = new Stack<>();
        Stack<StringBuilder> sb = new Stack<>();
        sb.push(new StringBuilder());
        int i=0;
        while(i<s.length()){
            char c = s.charAt(i);
            i++;
            if(Character.isDigit(c)){
                int num = c-'0';
                while(Character.isDigit(s.charAt(i))){
                    num = num *10 + s.charAt(i)-'0';
                    i++;
                }
                countstack.push(num);
            } else if(c=='['){
                sb.push(new StringBuilder());
            } else if(c==']'){
                StringBuilder last = sb.pop();
                int count = countstack.pop();
                while(count >0){
                    sb.peek().append(last);
                    count--;
                }
            } else
                sb.peek().append(c);
            
            
        }
        return sb.pop().toString();     
    }
}