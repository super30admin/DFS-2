// time complexity - O(m+n) n = max length of substring , m is max digit
// space complexity - O(n)
public class Solution
{
    public string DecodeString(string s)
    {
        Stack<int> stDigit = new Stack<int>();
        Stack<StringBuilder> stVal = new Stack<StringBuilder>();
        int currDigit = 0;
        StringBuilder currStr = new StringBuilder();
        for (int i = 0; i < s.Length; i++)
        {
            if (char.IsDigit(s[i]))
            {
                currDigit = currDigit * 10 + (int)(s[i] - '0');
            }
            else if (s[i] == '[')
            {
                stDigit.Push(currDigit);
                stVal.Push(currStr);
                currStr = new StringBuilder();
                currDigit = 0;
            }
            else if (s[i] == ']')
            {
                int count = stDigit.Pop();
                StringBuilder baby = new StringBuilder();
                while (count > 0)
                {
                    baby.Append(currStr);
                    count--;
                }
                StringBuilder parent = stVal.Pop();
                currStr = parent.Append(baby);
            }
            else
            {
                currStr.Append(s[i]);
            }
        }
        return currStr.ToString();
    }
}