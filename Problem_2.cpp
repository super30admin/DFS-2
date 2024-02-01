/*
 ? Problem: Decode String
 * Time Complexity : O(max(k) * n)
 * Space Complexity : O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

#include <string>
#include <stack>

class Solution {
public:
    std::string decodeString(const std::string& s) {
        std::stack<int> counts;
        std::stack<size_t> indexStack;
        std::string result;
        int k = 0;

        for (size_t i = 0; i < s.length(); ++i) {
            char ch = s[i];
            if (isdigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                counts.push(k);
                indexStack.push(result.length());
                k = 0;
            } else if (ch == ']') {
                std::string temp = result.substr(indexStack.top());
                result.resize(indexStack.top());

                for (int count = counts.top(); count > 0; --count) {
                    result += temp;
                }

                counts.pop();
                indexStack.pop();
            } else {
                result += ch;
            }
        }

        return result;
    }
};