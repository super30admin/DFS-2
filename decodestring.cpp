// Time Complexity : O(n) space complexity : O(n)

class Solution {
public:
    string decodeString(string s) {
        int n = s.length();
        if(n == 0) return "";
        
        int nums = 0;
        string currStr = "";
        
        stack<string> strStk;
        stack<int> numStk;
        
        for(int i=0;i<n;i++) {
            char ch = s[i];
            if(ch >= '0' && ch <= '9') {
                nums = nums * 10 + (ch - '0');
            } else if(ch == '[') {
                numStk.push(nums);
                strStk.push(currStr);
                nums = 0;
                currStr = "";
            } else if(ch == ']') {
                int times = numStk.top();
                numStk.pop();
                string newStr = "";
                for(int j=0;j<times;j++) {
                    newStr = newStr + currStr;
                }
                currStr = strStk.top() + newStr;
                strStk.pop();
            } else {
                currStr += ch;
            } 
        }
        return currStr;
    }
};