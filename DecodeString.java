// Time Complexity : O(n). n is the length of the string
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

class Solution {
    public String decodeString(String s) {
        
        int i=0;
        String charStr="";
        
        Stack<String>charStack=new Stack();
        Stack<Integer>digitStack = new Stack();
        
        int num=0;
        
        while(i<s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+(c-'0');
                i++;
            }else if(c=='['){
                charStack.push(charStr);
                digitStack.push(num);
                
                num=0;
                charStr="";
                i++;
            }else if(c==']'){
                
                int noOfTimes = digitStack.pop();
                StringBuilder sb = new StringBuilder();
                
                for(int f=0;f<noOfTimes;f++){
                    sb.append(charStr);
                }
                charStr=charStack.pop()+sb;
                i++;
            }else{
                charStr+=c;
                i++;
            }
            
        }
        return charStr;
    }
}
