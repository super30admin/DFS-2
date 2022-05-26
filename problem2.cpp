
//time complextiy : o(n) and space o(number of open brackets)
class Solution {
public:
    string decodeString(string s) {
        
        string curr = "" ;
        int num = 0;
        stack<string> st;
        stack<int> no;
        for(int i =0;i<s.length();i++) {
            
            char ch = s[i];
            if(isdigit(ch)){
                
                num = num*10 + ch -'0';
                
            } else if(ch == '['){
                st.push(curr);
                no.push(num);
                curr = "";
                num = 0;
            } else if(ch == ']') {
                
                int size = no.top();
                no.pop();
                
                string newstr;
                for(int i =0;i<size;i++) {
                    newstr = newstr + curr;
                }
                string old = st.top();
                
                old += newstr;
                st.pop();
                curr = old; 
                
            } else {
                curr = curr + ch;
            }
        }
        
        return curr;
    }
};