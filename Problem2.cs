// Time Complexity : O(n*k) where n is the length of the string and k is the max count
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


public class Solution {
    public string DecodeString(string s) {
        StringBuilder sb = new StringBuilder();
        Stack<int> numSt = new();
        Stack<StringBuilder> stringSt = new();
        int num = 0;


        for(int i = 0; i < s.Length; i++)
        {
            char ch = s[i];
            
            if(char.IsDigit(ch))
            {
                num = num * 10 + (ch - '0');
            }

            else if(ch == '[')
            {
                numSt.Push(num);
                stringSt.Push(sb);
                num = 0;
                sb = new();
            }

            else if(ch == ']')
            {
                int count = numSt.Pop();
                StringBuilder tempSt = new();

                for(int j = 0; j < count; j++)
                {
                    tempSt.Append(sb);
                }

                StringBuilder parentSt = stringSt.Pop();
                sb = parentSt.Append(tempSt);
            }

            else
            {
                sb.Append(ch);
            }

        }



        return sb.ToString();

    }
}