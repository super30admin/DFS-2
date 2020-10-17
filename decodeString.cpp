//time complexity:O(maxk*n)
//space complexity:O(maxk*n)
//executed on leetcode: yes
//approach:using stack
//any issues faced? yes, but understood it

class Solution {
public:
    string decodeString(string s) {
        stack<char>stack;
        for(int i=0; i<s.size(); i++)
        {
            if(s[i]==']')
            {
                string ds="";
                while(stack.top()!='[')
                {
                    ds=ds+stack.top();
                    stack.pop();
                    
                }
                stack.pop();
                int base=1;
                int digit=0;
                while(!stack.empty() && isdigit(stack.top()))
                {
                    digit=digit+(stack.top()-'0')*base;
                    stack.pop();
                    base=base*10;
                }
                while(digit!=0)
                {
                    for(int j=ds.size()-1; j>=0; j--)
                    {
                        stack.push(ds[j]);
                    }
                    digit--;
                }
            }
            else
            {
                stack.push(s[i]);
            }
        }
        string res;
        for(int i=stack.size()-1; i>=0; i--)
        {
            res=stack.top()+res;
            stack.pop();
        }
        return res;
    }
};