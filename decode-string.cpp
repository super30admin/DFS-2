//Time - O(n)
//SPace O(n)
class Solution {
public:
    string decodeString(string s) {
        stack<char> st;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] != ']') {
                st.push(s[i]);
            } else {
                string decode = "";
                while (st.top() != '[') {
                    decode += st.top();
                    st.pop();
                }
                st.pop(); 
                string num = "";
                while (!st.empty() && isdigit(st.top())) {
                    num += st.top();
                    st.pop();
                }
                reverse(num.begin(), num.end());
                int k = stoi(num);
                while (k != 0) {
                    for (int i = decode.size() - 1; i >= 0; i--) {
                        st.push(decode[i]);
                    }
                    k--;
                }
            } 
            
        }
        
        string ret;
        while (!st.empty()) {
            ret += st.top();
            st.pop();
        }
        reverse(ret.begin(), ret.end());
        return ret;
        
    }
};