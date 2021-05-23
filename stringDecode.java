import java.util.Stack;

// Time Complexity : O(k*n)
// Space Complexity :(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

public class stringDecode {

    public String decodeString(String s) {
        if(s==null || s.length()==0)
            return s;
        
        Stack<StringBuilder> strStack=new Stack<>();
        Stack<Integer> numStack=new Stack<>();
        int num=0;
        StringBuilder currStr=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            
            if(Character.isDigit(c)){
                num=num*10+c-'0';
            }else{
                if(c=='['){
                    numStack.add(num);
                    strStack.add(currStr);
                    num=0;
                    currStr=new StringBuilder();
                }else{
                    if(c==']'){
                        int time=numStack.pop();
                        StringBuilder newStr=new StringBuilder();
                        for(int k=0;k<time;k++){
                            newStr=newStr.append(currStr);
                        }
                        currStr=strStack.pop().append(newStr);
                    }else{
                        currStr=currStr.append(c);
                    }
                }
            }
        }
        return currStr.toString();
    }
    
}
