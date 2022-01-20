//Time Complexity O(string length)
// Space Complexity O(1)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
using namespace std;


class Solution {
public:
    int i=0;
    string decodeString(string s) {
        int num=0;
        string currStr="";
        while(i<s.size())
        {
            if(isdigit(s[i]))
            {
                num=num*10 + (s[i]-'0');
                i++;
            }
            else if(s[i]=='[')
            {
                i++;
                string st=decodeString(s);
                string newStr="";
                for(int j=0;j<num;j++)
                {
                    newStr+=st;
                }
                currStr+=newStr;
                num=0;
            }
            else if(s[i]==']')
            {
                ++i;
                return currStr;
            }
            else
            {
                currStr+=s[i];
                i++;
            }
        }
        return currStr;
    }
};