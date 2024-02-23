// TC = O(Length of output string)
//  SC = O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Recursive
// TC = O(Length of output string), SC = O(H); H = Max depth of stack/ no of nestings/ no of open braces
// class Solution {
// public:
//     int i;
//     string decodeString(string s) {
//         string currStr;
//         int num = 0;
//         while(i < s.size()) {
//             char c = s.at(i);
//             if(isdigit(c)) {
//                 i++;
//                 num = num * 10 + c - '0';
//             }
//             else if(c == '[') {
//                 i++;
//                 string decoded = decodeString(s); // calling recursion, passing s as gloabl i is taking care (instead of sending(substring))
//                 // parent --> currStr
//                 for(int j = 0; j < num; j++) currStr += decoded;
//                 num = 0;
//             }
//             else if(c == ']') {
//                 i++;
//                 return currStr;
//             }
//             else { // for chars
//                 i++;
//                 currStr += c;
//             }
//         }
//         return currStr;    
//     }
// };

// Iterative
// TC = O(Length of output string), SC = O(H); H = Max depth of stack/ no of nestings/ no of open braces
class Solution {
public:
    string decodeString(string s) {
        stack<string> strSt;
        stack<int> numSt;
        string currStr = "";
        int num = 0;
        for(int i = 0; i < s.size(); i++) {
            char c = s.at(i);
            if(isdigit(c)) num = num * 10 + c - '0';
            else if(c == '[') { // beginning of new nesting, put previous in stacks and reset vars
                strSt.push(currStr);
                numSt.push(num);
                currStr = "";
                num = 0;
            }
            else if(c == ']') { // 1 nesting is done, so we repeat it no of times and we append it to the parent
                int k = numSt.top(); numSt.pop();
                string temp = ""; // make a new StringBuilder to avoid bug
                for(int j = 0; j < k; j++) temp.append(currStr);
                string parent = strSt.top(); strSt.pop();
                currStr = parent.append(temp);
            }
            else currStr += c; // processing the chars
        }
        return currStr;
    }
};