// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Problem2 (https://leetcode.com/problems/decode-string/)
// Recursive
// Time O(l) and Space O(l) where l is the length of the string
class Solution {
    int id;
    public String decodeString(String s) {
        if(s == null || s.length() <= 0) return "";
        
        
        StringBuilder res = new StringBuilder();
        
        int num = 0;
        while(id < s.length()){
            char c = s.charAt(id);
            if(Character.isDigit(c)){
                id++;
                num = num * 10 + c - '0';
            }else if(c == '['){
                //[
                id++;
                String newStr = decodeString(s);
                while(num > 0){
                    res.append(newStr.toString());
                    num--;
                }
                
            }else if(c == ']'){
                //]
               id++;
               return res.toString();
                
            }else{
                id++;
                res.append(c);
            }
        }
        
        
        
        return res.toString();
        
    }
}
// Iterative
// Time O(l) and Space O(l) where l is the length of the string
class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() <= 0) return "";
        
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        
        StringBuilder resString = new StringBuilder("");
        
        int idx = 0, len = s.length();
        
        while(idx < len){
            if(Character.isDigit(s.charAt(idx))){
                //digit
                int num = 0;
                while(Character.isDigit(s.charAt(idx))){
                    num = num * 10 + s.charAt(idx) - '0';
                    idx++;
                }
                numStack.push(num);
               
            }else if(s.charAt(idx) == '['){
                //[
                strStack.push(resString.toString());
                resString = new StringBuilder("");
                idx++;
            }else if(s.charAt(idx) == ']'){
                //]
                int times = numStack.pop();
                StringBuilder temp = new StringBuilder(strStack.pop());
                for(int i = 0; i < times; i++){
                    temp.append(resString);
                }
                resString = temp;
                idx++;
                
            }else{
                //character
                resString.append(s.charAt(idx++));
            }
        }
        
        
        
        return resString.toString();
        
    }
}