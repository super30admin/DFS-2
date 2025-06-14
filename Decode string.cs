/*
  Time complexity: O(n*k) where n=Length of string; k=Product of repititions of all substrings
  Space complexity: O(n*k)

  Code ran successfully on Leetcode: Yes
*/

public class Solution {
    public string DecodeString(string s) {
        Stack<int> numStack = new();
        Stack<StringBuilder> strStack = new();
        int num = 0;
        StringBuilder currString = new();

        for(int i=0;i<s.Length;i++)
        {
            if(Char.IsDigit(s[i]))
            {
                num = num*10 + (s[i]-'0');
            }
            else
            if(s[i]=='[')
            {
                numStack.Push(num);
                strStack.Push(currString);

                num = 0;
                currString=new StringBuilder();
            }
            else
            if(s[i]==']')
            {
                int repeat = numStack.Pop();
                StringBuilder decoded = new();
                for(int r=0;r<repeat;r++)
                {
                    decoded.Append(currString);
                }
                currString = strStack.Pop().Append(decoded);
            }
            else
            {
                currString.Append(s[i].ToString());
            }
        }
        return currString.ToString();
    }
}
