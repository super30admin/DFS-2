using System;
using System.Collections.Generic;
using System.Text;

namespace DFS_And_BFS
{
    public class DecodeString
    {
        /*
         * T.C: O(n) where n is length of output string
         * S.C: O(D) where D is opening brackets
         */
        public string GetDecodeString(string s)
        {
            int num = 0;
            StringBuilder currString = new StringBuilder();

            Stack<StringBuilder> strStack = new Stack<StringBuilder>();
            Stack<int> numStack = new Stack<int>();


            for (int i = 0; i < s.Length; i++)
            {
                if (Char.IsDigit(s[i]))
                {
                    num = num * 10 + (s[i] - '0');

                }
                else if (s[i] == '[')
                {
                    numStack.Push(num);
                    strStack.Push(currString);
                    num = 0;
                    currString = new StringBuilder();
                }
                else if (s[i] == ']')
                {
                    int times = numStack.Pop();
                    StringBuilder newstr = new StringBuilder();
                    for (int j = 0; j < times; j++)
                    {
                        newstr.Append(currString.ToString());
                    }

                    currString = new StringBuilder().Append(strStack.Pop().ToString() + newstr.ToString());
                }
                else
                {
                    currString.Append(s[i]);
                }

            }
            return currString.ToString();
        }
    }
}
