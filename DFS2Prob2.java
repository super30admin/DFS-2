// Time Complexity : O(n), n is length of output/deciphered string
// Space Complexity : O(n), n is length of given input string
// Did this code successfully run on Leetcode : yes


// approach : Took two stack and implemented dfs

class Solution {
    public String decodeString(String s) {
        
        if( s== null || s.length() == 0)
            return s;
        
        Stack<StringBuilder> words = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        
        int num =0;
        StringBuilder current = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = num*10+(c-'0');
            }else if(c == '['){
                words.push(current);
                nums.push(num);
                current = new StringBuilder();
                num =0;
                
            }else if(c == ']'){
                int n = nums.pop();
                StringBuilder parent = words.pop();
                StringBuilder child = new StringBuilder();
                for(int k=0;k<n;k++){
                     child.append(current);
                }
                parent.append(child);
                current = parent;
                
            }else{
                current.append(c);
            }
        }
        return current.toString();
        
    }
}