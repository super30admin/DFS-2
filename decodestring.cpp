// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
public:
    string decodeString(string s) {
        stack<char> stack;
        
        for (int i = 0; i < s.length(); i++) {
            
            // Keep pushing to stack while the character is not '['
            if (s[i] != ']') 
            {
                stack.push(s[i]);
            }
            else 
            {
                
                // Get the string in between '[' and ']'
                string temp = "";
                while(stack.top() != '[')
                {
                   temp += stack.top();
                   stack.pop();
                }
                stack.pop();
                // Get the integer value
                int base = 1;
                int number = 0;
                while(!stack.empty() and isdigit(stack.top()))
                {
                    number += base * (stack.top() - '0');
                    stack.pop();
                    base *= 10;
                }
                
                // Add k*string back into stack
                for(int i = 0; i < number; i++)
                {
                    for(int j = temp.size() - 1; j >= 0; j--)
                    {
                        stack.push(temp[j]);
                    }
                }
                
            }
        }
        // Make result from stack
        string result;
        for (int i = stack.size() - 1; i >= 0; i--) {
            result = stack.top() + result;
            stack.pop();
        }
        return result;
    }
};

