// Time Complexity : O(maxKxn)
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : yes

#include <iostream>
#include <stack>

using namespace std;

class Solution {
public:
    string decodeString(string s) {
        stack<int> numStack;
        stack<string> strStack;
        string currStr = "";
        int currNum = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s[i];

            if (isdigit(c)) {
                currNum = currNum * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(currNum);
                strStack.push(currStr);
                currNum = 0;
                currStr = "";
            } else if (c == ']') {
                int times = numStack.top();
                numStack.pop();
                string newStr = "";

                for (int j = 0; j < times; j++) {
                    newStr += currStr;
                }

                currStr = strStack.top() + newStr;
                strStack.pop();
            } else {
                currStr += c;
            }
        }

        return currStr;
    }
};