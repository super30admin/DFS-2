class Solution {
public:
    string decodeString(string s) {
        stack<char> st;
        for(int i=0;i<s.length();i++){
            if(s[i]!=']'){
                st.push(s[i]);
            }
          
            else{
                  string curr="";
                while(st.top()!='['){
                    curr=st.top()+curr;
                    st.pop();
                }
                st.pop();
                string number="";
                while(!st.empty()&&isdigit(st.top())){
                    number=st.top()+number;
                    st.pop();
                }
                      
            
            int time=stoi(number);
            while(time--){
                for(int i=0;i<curr.size();i++){
                    st.push(curr[i]);
                }
            }
            }
        }
        s="";
        while(!st.empty()){
            s=st.top()+s;
            st.pop();
        }
        return s;
    }
};