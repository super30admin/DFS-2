// Time Complexity : O(maxK*n) k is numbers in the stirng and n is length
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

#include <iostream>
#include <stack>
class Solution {
public:
    string decodeString(string s) {
        int index = 0;
        return decodeString(s, index);
    }
    string decodeString(const string& s, int& index) {
        string ans;
        while (index < s.length() && s[index] != ']') {
            if (!isdigit(s[index]))
                ans += s[index++];
            else {
                int k = 0;
                // build k while next character is a digit
                while (index < s.length() && isdigit(s[index]))
                    k = k * 10 + s[index++] - '0';  
                // ignore the opening bracket '['    
                index++;
                string decodedString = decodeString(s, index);
                // ignore the closing bracket ']'
                index++;        
                while (k-- > 0)
                    ans += decodedString;
            }
        }
        return ans;
    }
};