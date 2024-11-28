// Time Complexity :O(n)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

import java.util.Stack;

public class Problem2 {
    public String decodeString(String s) {
        int n= s.length();
        Stack<Integer> numStk = new Stack<>();
        Stack<StringBuilder> strStk = new Stack<>();
        int curNum=0;
        StringBuilder curStr = new StringBuilder();

        for( int i=0; i<n; i++){
            char c= s.charAt(i);
            if(Character.isDigit(c)){
                curNum = curNum*10+c-'0';
            }else if(c=='['){
                numStk.push(curNum);
                strStk.push(curStr);
                curNum=0;
                curStr= new StringBuilder();
            }else if(c==']'){
                int count = numStk.pop();
                StringBuilder baby = new StringBuilder();
                for(int k=0; k<count; k++){
                    baby.append(curStr);
                }
                StringBuilder parent = strStk.pop();
                parent.append(baby);
                curStr=parent;
            }else{
                curStr.append(c);
            }
        }
        return curStr.toString();
    }
}
