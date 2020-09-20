//*Used Single Stack Approach*
// Time Complexity :O(n) n= Length of the String
// Space Complexity :O(n) For stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Use a stack to store the sequence to execute the given decoded string
// iterate over string and if store the digits and strings in variables (keep track for every iteration).
// if you encounter open bracket "[", add string and number to stack and make those variables null
// if you find closed bracket "]", pop out the stack and add them to same string using a for loop and again add to before string by popping out again.
// repeat the same again till the end of the string and return the string.

class Solution {
    public String decodeString(String s) {
        if(s.length()==0 || s==""){
            return "";
        }
        
        Stack<Object> stack = new Stack<>();
        
        int num=0;
        String str = "";
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num*10+ch-'0';
            }else if(ch=='['){
                stack.add(str);
                stack.add(num);
                num=0;
                str="";
            }else if(ch==']'){ 
                int numpop = (int)stack.pop();
                String str1="";
                for(int j=0;j<numpop;j++){
                    str1+=str;    
                }
                String pop=stack.pop().toString();
                str=pop+str1;
                
            }else if(Character.isAlphabetic(ch)){
                str = str+ch;
            }  
        }
        return str;
        
    }
}