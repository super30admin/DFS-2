/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*/

// T: O(N) where N is the String Length
// S: O(2N)

class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> intStack  = new Stack<Integer>();
        Stack<String> strStack = new Stack<String>();
        
        String curString = "";
        int num = 0;
        
        for(int i = 0; i < s.length(); i++){
            
            Character c = s.charAt(i);
            
            if(Character.isDigit(c)){
                
                num = num * 10 + (c - '0');
            }
            else if(c == '['){
                
                intStack.push(num);
                strStack.push(curString);
                num = 0;
                curString = "";
            }
            else if(c == ']'){
                
                StringBuilder str1 = new StringBuilder();
                int times = intStack.pop();
                
                for(int j = 0; j < times; j++){
                    
                    str1.append(curString);
                }
                
                curString = strStack.pop();
                curString += str1.toString();
            }
            else{
                curString += c;
            }
        }
        
        return curString;
    }
}

// DFS Solution
// Beats 100% of LeetCode Submissions

class Solution {
    
    int i = 0; // Making it golbal so that in recursion it does not change
    
    public String decodeString(String s) {
        
        StringBuilder str = new StringBuilder();
        int num = 0;
        
        for(; i < s.length(); i++){
            
            Character c = s.charAt(i);
            
            if(c >= '0' && c <= '9'){
                num = num * 10 + (c - '0');
            }
            else if(c == '['){
                
                i++;
                
                String next = decodeString(s);
                
                for(int j = 0; j < num; j++){
                    str.append(next);
                }
                
                num = 0;
            }
            else if(c == ']'){
                
                return str.toString();
            }
            
            else {
                
                str.append(c);
            }
        }
        
        return str.toString();
    }
}