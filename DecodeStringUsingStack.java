package DFS2;

import java.util.Stack;
// Time Complexity : O(Kl)  -> k is the product of the numbers in the input string & l is the length of the input string
// Space Complexity : O(Kl)
// Did this code successfully run on Leetcode : Yes
public class DecodeStringUsingStack {
    public String decodeString(String s) {

        int i=0;
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        StringBuilder curStr = new StringBuilder();
        int curNum = 0;

        while(i<s.length())
        {
            char c = s.charAt(i);
            i++;

            if(Character.isDigit(c))
            {
                curNum = curNum*10 + c -'0';
            }else if(c == '[')
            {
                numSt.push(curNum);
                strSt.push(curStr);
                curNum = 0;
                curStr = new StringBuilder();
            }
            else if(c == ']')
            {
                int num = numSt.pop();
                StringBuilder temp = new StringBuilder();
                for(int k=0; k<num; k++)
                {
                    temp.append(curStr);
                }
                curStr = strSt.pop().append(temp);
            }
            else{
                curStr.append(c);
            }

        }
        return curStr.toString();
    }
}
