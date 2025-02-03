// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: 394: Decode String
// Approach: Stack
// TC: O(n*k)
// SC: O(n*k)

class Solution
{
public:
    string decodeString(string s)
    {

        // BaseCase
        if (s.empty())
        {
            return "";
        }

        // Variables to be used
        string currStr = "";
        stack<int> numStack;
        stack<string> strStack;
        int num = 0;

        // Loop the string
        for (char c : s)
        {

            // Check if digit
            if (isdigit(c))
            {
                num = num * 10 + (c - '0');
            }

            // Check if opening bracket
            else if (c == '[')
            {
                numStack.push(num);
                strStack.push(currStr);
                num = 0;
                currStr = "";
            }

            // Check if closing bracket
            else if (c == ']')
            {
                int times = numStack.top();
                numStack.pop();
                string newStr = "";
                for (int j = 0; j < times; j++)
                {
                    newStr += currStr;
                }
                currStr = strStack.top() + newStr;
                strStack.pop();
            }

            // If a regular charachter
            else
            {
                currStr += c;
            }
        }

        return currStr;
    }
};