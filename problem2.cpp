// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// we maintain two stacks one for storing num and another for storing string. The idea is to maintain num and currstring untill 
// we reach a '[' or a ']'. when we reach a '[' we perform push and when we reach a ']', we perfor pop. by properly looking at the values.
// and calculating the num and currstring , we can solve it.


class Solution {
public:
    string decodeString(string s) {
        if(s.empty() || s.size()==0) return "";
        stack<int>numSt;
        stack<string>strSt;
        string currStr;
        int num = 0;
        for(int i = 0;i< s.size();i++)
        {
            if(isdigit(s[i]))
            {
                num = num*10 + s[i]-'0';
            }
            else if(s[i] == '[')
            {
                numSt.push(num);
                strSt.push(currStr);
                num = 0;
                currStr = "";
            }
            else if(s[i] == ']')
            {
                int t = numSt.top();numSt.pop();
                string nn;
                while(t--)
                {
                    nn+=currStr;
                }
                currStr = strSt.top() + nn;
                strSt.pop();
            }
            else
            {
                currStr+=s[i];
            }
        }
        return currStr;
    }
};