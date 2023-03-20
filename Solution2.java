// Time Complexity : O(n) (Total length of resultant string)
// Space Complexity : O(n) (Number of opening brackets in input string)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public String decodeString(String s) {
        StringBuilder currStr = new StringBuilder();
        int num = 0;
        Stack<StringBuilder> strSt = new Stack<>();
        Stack<Integer> numSt = new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                num=num*10 + (c-'0');
            }
            else if(c=='[')
            {
                strSt.push(currStr);
                numSt.push(num);
                num=0;
                currStr = new StringBuilder();
            }
            else if(c==']')
            {
                StringBuilder temp = new StringBuilder();
                int k = numSt.pop();
                for(int j=0;j<k;j++)
                {
                    temp.append(currStr);
                }
                StringBuilder parent = strSt.pop();
                currStr = parent.append(temp);
            }
            else
            {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}