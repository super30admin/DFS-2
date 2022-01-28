// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public String decodeString(String s) {
        // check whether strign is null or empty
        if(s == null || s.length() == 0) return s;
        
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int num = 0;
        StringBuilder curr = new StringBuilder();
        
        // traverse the string
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            // digit
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            } else if(c == '['){
                numStack.push(num);
                strStack.push(curr);
                num = 0;
                curr = new StringBuilder();
        
            } else if(c == ']'){
                // decipher the child according to the number
                int repitition = numStack.pop();
                StringBuilder child = new StringBuilder();
                
                // appending to child according to the repitition 
                for(int k = 0; k < repitition; k++){
                    child.append(curr);
                }
                
                // combine with the parent
                StringBuilder parent = strStack.pop();
                curr = parent.append(child);
            } else{
                curr.append(c);
            }
        }
        return curr.toString();
    }
}