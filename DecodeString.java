// Time Complexity : O(N * K) where N is length of string and K is product of numbers in the string.
// Space Complexity : O(N * K) where N is length of string and K is product of numbers in the string.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class DecodeString {
    public String decodeString(String s)
    {
        Stack<Integer> numSt = new Stack();
        Stack<StringBuilder> strSt = new Stack();
        int num = 0;
        StringBuilder curStr = new StringBuilder();
        for(int  i =0; i < s.length(); i++)
        {
            char c = s.charAt(i);

            if(Character.isDigit(c))
                num = (num * 10) + (c - 48);
            else if (c == '[')
            {
                numSt.push(num);
                strSt.push(curStr);
                curStr = new StringBuilder(); num = 0;
            }
            else if (c == ']')
            {
                int count = numSt.pop();
                StringBuilder child = new StringBuilder();
                for(int k = 0 ; k < count ; k++)
                {
                    child.append(curStr);
                }
                curStr = strSt.pop().append(child.toString());
            }
            else
                curStr = curStr.append(c);

        }
        return curStr.toString();
    }
}
