/*
TC : O(N)
SC : O(N) where n is the # of nested brackets
*/
class Solution
{
public:
    string decodeString(string s)
    {
        if (s.empty() || s.size() == 0)
        {
            return s;
        }

        string currString;   // keep track of curr string
        int num = 0;         // keep track of curr digits
        stack<string> store; // keep track of prev string
        stack<int> val;      // keep track of prev num

        for (int i = 0; i < s.size(); i++)
        {
            if (isdigit(s[i]))
            {
                num = num * 10 + (s[i] - '0');
            }
            else if (s[i] == '[')
            {
                store.push(currString);
                val.push(num);
                num = 0;
                currString = "";
            }
            else if (s[i] == ']')
            {
                int times = val.top();
                val.pop();
                string temp = "";
                for (int j = 0; j < times; j++)
                {
                    temp.append(currString);
                }
                currString = store.top() + temp;
                store.pop();
            }
            else
            {
                currString.append(1, s[i]);
            }
        }
        return currString;
    }
};