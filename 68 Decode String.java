// Time Complexity : O(n)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public String decodeString(String s) {
        //aesha
        int currNum = 0;
        StringBuilder currStr = new StringBuilder();
        Stack<Integer> numStr = new Stack<>();
        Stack<StringBuilder> strst = new Stack<>();

        for(int i=0;i<s.length(); i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                currNum = currNum * 10 + c - '0';
            }
            else if(c =='[')
            {
                numStr.push(currNum);
                strst.push(currStr);
                currNum = 0;
                currStr = new StringBuilder();
            }
            else if(c == ']')
            {
                int cnt = numStr.pop();
                StringBuilder baby = new StringBuilder();
                for(int k=0; k<cnt; k++)
                {
                    baby.append(currStr);
                }
                StringBuilder parent = strst.pop();
                parent.append(baby);
                currStr = parent;
            }
            else
            {
                currStr.append(c);
            }
        }
        return currStr.toString();    
    }
}