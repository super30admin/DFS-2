class Solution {
public:
    string decodeString(string s) {
        string curr="";
        int num=0;
       
        stack<string> str;
        stack<int> n;
        for(int i=0;i<s.size();++i)
        {
            if(isdigit(s[i]))
            {
                num=num*10+s[i]-'0';
            }
            else if(s[i]=='[')
            {
                str.push(curr);
                 n.push(num);
                 curr="";
                 num=0;
            }
            else if(s[i]==']')
            {
                
                int number=n.top();
                n.pop();
                string newStr="";
                while(number)
                {
                    newStr+=curr;
                    number--;
                }
               curr=str.top()+newStr;
               str.pop();
            }
            else
            {
                curr+=s[i];
            }
        }
        return curr;
    }
};