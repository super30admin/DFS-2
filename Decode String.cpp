//Time Complexity- O(maxK*n)
//Space Complexity- O(n)

class Solution {
public:
    string decodeString(string s) {
        int index = 0;
        return decodeString(s, index);
    }
    string decodeString(const string& s, int& index) {
        string result;
        while (index < s.length() && s[index] != ']') {
            if (!isdigit(s[index]))
                result += s[index++];
            else {
                int k = 0;
                // build k while next character is a digit
                while (index < s.length() && isdigit(s[index]))
                    k = k * 10 + s[index++] - '0';  
                // ignore the opening bracket '['    
                index++;
                string decodedString = decodeString(s, index);
                // ignore the closing bracket ']'
                index++;        
                while (k-- > 0)
                    result += decodedString;
            }
        }
        return result;
    }
};