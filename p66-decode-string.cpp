// Using BFS
// Time complexity is O(n) - n = #characters in the string
// Space complexity is O(n*k) - k = number of times a substring is to be repeated in the given string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
public:
    string decodeString(string s) {
        if(s == "") return s;
        
        int num = 0;
        string currStr = "";
        stack<int> numStack;
        stack<string> strStack;
        
        for(int i = 0; i < s.size(); i++) {
            if(isdigit(s[i])) {
                num = num*10 + s[i] - '0';
                
            }
            else if(isalpha(s[i])) {
                currStr.append(1, s[i]);
            }
            else if(s[i] == '[') {
                numStack.push(num);
                strStack.push(currStr);
                num = 0;
                currStr = "";
            }
            else if(s[i] == ']') {
                int tempInt = numStack.top();
                numStack.pop();
                string tempStr = currStr;
                currStr = "";
                for(int i = 0; i < tempInt; i++) {
                    currStr += tempStr;
                }
                currStr = strStack.top() + currStr;
                strStack.pop();
            }
        }
        return currStr;
    }
};
