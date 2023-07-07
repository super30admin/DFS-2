//Time Complexity: O(n)
//Space Complexity: O(n)

class Solution {
public:
    string decodeString(string s) {
        deque<pair<int, string>> st; 
        int currNum = 0; 
        string currStr = ""; 

        for(int i = 0; i < s.size(); i++) {
            if(isdigit(s[i])) {
                currNum = currNum*10 + (s[i] - '0');
            }
            else if(s[i] == '[') {
                st.push_back({currNum, currStr});
                currNum = 0; 
                currStr = "";
            } else if(s[i] == ']') {
                pair<int,string> top = st.back(); 
                st.pop_back(); 
                string localStr = currStr; 
                for(int i = 1; i < top.first; i++) currStr += localStr;                 
                currStr = top.second + currStr; 
            } else {
                currStr += s[i];
            }
        }

        return currStr;        
    }
};