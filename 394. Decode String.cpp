
/*
Time Complexity = O(K*N)
Space Complexity = O(K*N)
where K is the sum of the digits and N is the total number of characters.
*/
class Solution {
public:
    string decodeString(string s) {
        int i,j,num=0;
        string curr;
        stack<int> numstack;
        stack<string> strstack;
        for(i=0;i<s.length();i++)
        {
            char c = s[i];
            if(isdigit(s[i]))
                num = num*10+(c - '0');
            else if(c == '[')
            {
                numstack.push(num);
                strstack.push(curr);
                num=0;
                curr = "";
            }
            else if(c == ']')
            {
                int time = numstack.top();
                numstack.pop();
                string newstr;
                for(j=0;j<time;j++)
                    newstr.append(curr);
                curr = strstack.top().append(newstr);
                strstack.pop();
            }
            else
                curr+=c;
        }
        return curr;
    }
};

/*
Time Complexity = O(K*N)
Space Complexity = O(K*N)
where K is the sum of the digits and N is the total number of characters.
*/
class Solution {
public:
    int i;
    string decodeString(string s) {
        int num=0;
        string curr;
        while(i<s.length())
        {
            char c = s[i];
            i++;
            if(isdigit(c))
                num = num * 10 + (c - '0');
            else if(c == '[')
            {
                string str = decodeString(s);
                string newstr;
                for(int j=0;j<num;j++)
                    newstr.append(str);
                curr.append(newstr);
                num = 0;
            }
            else if(c == ']')
                return curr;
            else
                curr+=c;
        }
        return curr;
    }
};
