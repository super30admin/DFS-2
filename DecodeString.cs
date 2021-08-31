
public class Solution {
    //Time Complexity: O(KN) K = sum of numbers N = Characters
    //Time Complexity: O(KN) 
    public string DecodeString(string s) {
          if (s == null || s.Length == 0) return s;
            int num = 0;
            StringBuilder currString = new StringBuilder();
            Stack<int> numStack = new Stack<int>();
            Stack<StringBuilder> strStack = new Stack<StringBuilder>();
            for (int i = 0; i < s.Length; i++)
            {
                char c = s[i];
                if (char.IsDigit(c))
                {
                    num = num * 10 + (c - '0');
                }
                else if (c == '[')
                {
                    numStack.Push(num);
                    strStack.Push(currString);
                    num = 0;
                    currString = new StringBuilder();
                }
                else if (c == ']')
                {
                    int times = numStack.Pop();
                    StringBuilder newString = new StringBuilder();
                    for (int j = 0; j < times; j++)
                    {
                        newString.Append(currString);
                    }
                    currString = strStack.Pop().Append(newString);
                }
                else
                {
                    currString.Append(c);
                }
            }
            return currString.ToString();
    }
}