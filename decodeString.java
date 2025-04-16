// Time Complexity : O(n * k), where n is the length of the input string and k is the max repeat count
// Space Complexity : O(n), for the stacks and output string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

// Approach:
// Traverse characters; build number for repeat count and use stacks to store counts and intermediate results.
// On ']', pop count and previous string, then append current built string multiplied by count.
// Continue building the final result by appending normal characters or decoded segments.



import java.util.*;

public class decodeString
{
    public String decodeString(String s) {
        int num = 0;
        StringBuffer st = new StringBuffer();
        char[] ch = s.toCharArray();
        Stack<Integer> si  = new Stack<>();
        Stack<String> ss  = new Stack<>();
        for(int i=0;i<ch.length;i++)
        {
            if(Character.isDigit(ch[i]))
            {
                num = num*10+(ch[i]-'0');
            }
            else if(ch[i] == '[')
            {
                si.add(num);
                String sd = st.toString();
                ss.add(sd);
                num = 0;
                st = new StringBuffer();
            }
            else if(ch[i] == ']')
            {
                int x = si.pop();
                String sd = st.toString();
                while(x>1)
                {
                    st.append(sd);
                    x--;
                }
                if(!ss.isEmpty())
                {
                    StringBuffer result = new StringBuffer(ss.pop());
                    result.append(st);
                    st = new StringBuffer(result);
                }
            }
            else
            {
                st.append(ch[i]);
            }
        }
        return st.toString();
    }
}