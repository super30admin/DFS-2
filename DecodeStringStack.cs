public class Solution
{
    public string DecodeString(string s)
    {
        if (string.IsNullOrEmpty(s))
        {
            return null;
        }

        int num = 0;
        StringBuilder currStr = new StringBuilder();
        Stack<int> numStack = new Stack<int>();
        Stack<StringBuilder> stringStack = new Stack<StringBuilder>();

        for (int i = 0; i < s.Length; i++)
        {
            if (Char.IsDigit(s[i]))
            {
                num = 10 * num + (s[i] - '0');
            }
            else if (s[i] == '[')
            {
                numStack.Push(num);
                num = 0;
                stringStack.Push(currStr);
                currStr = new StringBuilder();
            }
            else if (s[i] == ']')
            {
                var times = numStack.Pop();
                var newStr = new StringBuilder();
                for (int j = 0; j < times; j++)
                {
                    newStr.Append(currStr);
                }
                currStr = stringStack.Pop().Append(newStr);
            }
            else
            {
                currStr.Append(s[i]);
            }
        }
        return currStr.ToString();
    }
}