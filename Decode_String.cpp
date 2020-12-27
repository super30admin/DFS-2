// Time Complexity : O(maxK * n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : very difficult :(

class Solution {
public:
    string decodeString(string s) {
        stack<int> countStack;
        stack<string>stringStack;
        string currentString;
        int k = 0;
        for(auto ch: s){
            if(isdigit(ch)){
                k = k*10+ch-'0';
            }
            else if(ch == '['){
                countStack.push(k);
                stringStack.push(currentString);
                currentString = "";
                k = 0;
            }
            else if(ch == ']'){
                string decodedString = stringStack.top();
                stringStack.pop();
                for(int i=countStack.top(); i>0;i--){
                    decodedString = decodedString + currentString;
                }
                countStack.pop();
                currentString = decodedString;
            }
            else{
                currentString = currentString + ch;
            }
        }
        return currentString;
    }
};
