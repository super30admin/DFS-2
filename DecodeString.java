// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<String> stack=new Stack<>();
        Stack<Integer> numStack=new Stack<>();
        String currString="";
        int num=0;
        for(int i=0;i<s.length();i++){
            Character c=s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+(c-'0');
            }else if(c=='['){
                stack.push(currString);
                numStack.push(num);
                currString="";
                num=0;
            }else if(c==']'){
                String temp="";
                int count=numStack.pop();
                for(int j=0;j<count;j++){
                    temp+=currString;
                }
                currString=stack.pop()+temp;
            }else{
                currString=currString+c;
            }
        }
        
        return currString;
    }
}
