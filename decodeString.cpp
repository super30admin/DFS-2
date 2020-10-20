class Solution {
public:
    string decodeString(string s) {
        stack<char> stk;
        
         for (int i=0;i<s.length();i++) {
            string decodedString="";
             if (s[i]==']') { 
                while (stk.top()!='[') {
                    decodedString.push_back(stk.top());
                    stk.pop();
                }      
                 stk.pop();
                
                 int base=1;
                 int num=0;
                while (!stk.empty() && isdigit(stk.top())) {
                    num+=(stk.top()-'0')*base;
                    base*=10;
                    stk.pop();
                 }
                //cout<<"num: "<<num<<" base: "<<base<<endl;
                while (num!=0) {
                    for (int j=decodedString.size()-1;j>=0;j--) {
                        stk.push(decodedString[j]);
                    }
                    num--;
                }
             } else {
                 stk.push(s[i]);
             }
         }
        
        string answer="";
        while (!stk.empty()) {
            answer+=stk.top();
            stk.pop();
        }
        reverse(answer.begin(),answer.end());
        return answer;
    }
};