// Time Complexity : O(n*m), n = length of string, m = max repeat count
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Keep track of the current string and current number
// When we encounter a [, it means a new child is starting, put currStr and currNum into the stacks and reset the variables
// When we encounter a ], decode the child (currStr) and append it to the parent (strStack.top()) and make this the new currStr (child)

class Solution {
private:
    string decode(string str, int count) {
        string res = "";
        for(int i=0; i<count; i++) {
            res += str;
        }
        return res;
    }
public:
    string decodeString(string s) {
        stack<string> strStack;
        stack<int> numStack;
        int i=0; int n = s.length();
        int currNum = 0; string currStr = "";
        while(i < n) {
            char ch = s[i];
            // num
            if(isdigit(ch)) {
                currNum = currNum*10 + (ch - '0');
            }

            if(isalpha(ch)) {
                currStr += ch;
            }

            if(ch == '[') {
                numStack.push(currNum);
                strStack.push(currStr);
                currNum = 0;
                currStr = "";
            }

            if(ch == ']') {
                // decode child
                string decoded = decode(currStr, numStack.top());
                numStack.pop();
                // combine decoded child with parent (strStack.top())
                currStr = strStack.top() + decoded;
                strStack.pop();
            }
            i++;
        }
        return currStr;
    }
};