import java.util.Stack;

// Time Complexity :O(len(outputString))
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public String decodeString(String s) {
        Stack <Integer> st = new Stack<>();
        Stack<String> charst = new Stack <>();
        int digits = 0;
        String curr = "";
        for(char c:s.toCharArray())
        {
            if(Character.isDigit(c))
            {
                digits = digits * 10 + c-'0';
            }
            else if(Character.isAlphabetic(c))
            {
                curr +=c;
            }
            else if(c=='[')
            {
                st.push(digits);
                charst.push(curr);
                digits= 0;
                curr = "";
            }
            else
            {
                int time = st.pop();
                StringBuilder sb = new StringBuilder();
                for(int x = 0; x<time;x++)
                {
                    sb.append(curr);
                }
                curr= charst.pop() + sb;
            }
        
        }
        return curr;
        
    }
}