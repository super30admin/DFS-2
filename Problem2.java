package DFS2;

import java.util.Stack;
/**
 * 
 * Here we go in to process the innermost string and return that result to its parent and so on (like recursive dfs).
 *  
 * Time Complexity : length of the output string 
 * 
 * Space Complexity : length of output string (as it will have to be stored in the stack worst case)
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
public class Problem2 {
    public String decodeString(String s) {
        StringBuilder currStr=new StringBuilder("");
        int currNo=0;
        Stack<Integer> numStack=new Stack<>();
        Stack<StringBuilder> strStack=new Stack<>();



        for(Character c : s.toCharArray()){
            if(Character.isDigit(c)){
                currNo=currNo*10+(c-'0');
            }
            else if(c=='['){
                strStack.push(currStr);
                numStack.push(currNo);
                currStr=new StringBuilder("");
                currNo=0;
            }
            else if(c==']'){
                int mul=numStack.pop();
                StringBuilder temp=new StringBuilder();

                for(int i=0;i<mul;i++){
                    temp.append(currStr);
                }
                currStr=strStack.pop();
                currStr.append(temp);
            }
            else{
                currStr.append(c);
            }
        }

        return currStr.toString();
    }

}
