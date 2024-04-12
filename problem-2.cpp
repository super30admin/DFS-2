// 394. Decode String
// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
public:
    string decodeString(string s) {
        stack<int> numst;
        stack<string> strst;
        string currstr = "";
        int currnum = 0;
        for(int i = 0; i < s.size(); i++)
        {
            if(s[i] == ']')
            {
                string result = "";
                for(int  k = 0; k < numst.top(); k++)
                {
                    result += currstr;
                }
                currstr = result;
                if(!strst.empty())
                {
                    currstr = strst.top() + currstr;
                    numst.pop();
                    strst.pop();
                }
            }
            else if(s[i] >= 'a' && s[i] <= 'z')
            {
                currstr += s[i];
            }
            else if(s[i] >= '0' && s[i] <= '9')
            {
                currnum = currnum*10 + (s[i] - '0');
            }
            else if(s[i] == '[')
            {
                numst.push(currnum);
                currnum = 0;
                strst.push(currstr);
                currstr = "";      
            }

        }
        return currstr;
    }
};
