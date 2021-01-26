// Time Complexity : o(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    int i = 0;
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return s;
        StringBuilder res = new StringBuilder();
        int currval =0;
        while(i < s.length())
        {
            char curr = s.charAt(i);
            if(Character.isDigit(curr))
            {
                currval = currval * 10 + curr - '0';
                i++;
            }
            else if(curr == '[')
            {
                i++;
                String dec = decodeString(s);
                for (int j =0 ; j< currval; j++)
                {
                    res.append(dec);
                }
                currval = 0;
            }
            else if(curr == ']')
            {
                i++;
                return res.toString();
            }
            else
            {
                res.append(curr);
                i++;
            }
        }
        return res.toString();
    }
}