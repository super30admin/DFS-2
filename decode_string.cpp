class Solution {
public:
    string decodeString(string s) {  
        int curr_num=0;
        string curr_str,prev_str;
        stack<int>n;
        stack<string>c;
        int i=0;
        while(i<s.size())
        {
            if(isdigit(s[i]))
                curr_num=curr_num*10+s[i]-'0';
            else if(isalpha(s[i]))
                curr_str.push_back(s[i]);
            else if(s[i]=='[')
            {
                c.push(curr_str);
                n.push(curr_num);
                curr_num=0;
                curr_str="";
            }
            else
            {
                int x=n.top();
                n.pop();
                prev_str=c.top();
                c.pop();
                string new_curr;
                for(int i=0;i<x;i++)
                    new_curr=new_curr+curr_str;
                curr_str=prev_str+new_curr;
            }
            i++;
        }
        return curr_str;
    }
};