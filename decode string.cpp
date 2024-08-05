//time: O(n) - n: len of resulting str
class Solution {
public:
    string decodeString(string s) {
        stack<string> strSt;
        stack<int> numSt;
        int currNum = 0;
        string currStr = "";
        for(int i = 0; i < s.length(); i++) {
            char c = s[i];
            if(c >= '0' && c <= '9') {
                currNum = currNum*10 + (c - '0');
            }
            else if(c == '[') {
                numSt.push(currNum);
                strSt.push(currStr);
                currNum = 0;
                currStr = "";
            }
            else if(c == ']') {
                //pop the num...get the num corr to baby
                int cnt = numSt.top();
                numSt.pop();
                string baby = "";
                for(int k = 0; k < cnt; k++) {
                    baby += currStr;
                }
                //combine it with parent
                string parent = strSt.top();
                strSt.pop();
                parent += baby;
                currStr = parent;
            }
            else {
                currStr += c;
            }
        }
        return currStr;
    }
};