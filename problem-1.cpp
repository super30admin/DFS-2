// https://leetcode.com/problems/decode-string/description/
// Time Complexity : O(max(k,n)) where is the product of all the digits and n is the lenght of the string
// Space Complexity : O(max(k,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Iterate through the input string, have two stacks to store the number and string.
// If the current element is a digit, add it to the curNum. If it is '[', then push the current num and str to their stacks and re-initialize them.
// If it is ']', then pop the num from the stack and mutliply the current string that many times and append it to the parent and make it current string.
// if it is a char, then just append it to the current string.

class Solution {
    public:
        string decodeString(string s) {
            stack<int> num; stack<string> str;
            int curNum=0; string curStr="";
            for(int i=0; i<s.length(); i++){
                if(isdigit(s[i])){
                    curNum = curNum*10 + s[i]-'0';
                }
                else if(s[i] == '['){
                    num.push(curNum);
                    str.push(curStr);
                    curNum = 0;
                    curStr = "";
                }
                else if(s[i] == ']'){
                    int cnt = num.top();
                    num.pop();
                    string baby = "";
                    for(int i=0; i<cnt; i++){
                        baby.append(curStr);
                    }
                    string parent = str.top();
                    str.pop();
                    curStr = parent+baby;
                }
                else{
                    curStr += s[i];
                }
    
            }
            return curStr;
        }
    };

    // Solution - 2 using recursion

    class Solution {
        public:
            int i = 0;
            string decodeString(string s) {
                int curNum=0; string curStr="";
                while(i < s.length()){
                    if(isdigit(s[i])){
                        curNum = curNum*10 + s[i]-'0';
                        i++;
                    }
                    else if(s[i] == '['){
                        i++;
                        string decoded = decodeString(s);
                        string baby = "";
                        for(int i=0; i<curNum; i++){
                            baby += decoded;
                        }
                        curNum = 0;
                        curStr += baby;
                        i++;
                    }
                    else if(s[i] == ']'){
                        return curStr;
                    }
                    else{
                        curStr += s[i];
                        i++;
                    }
        
                }
                return curStr;
            }
        };