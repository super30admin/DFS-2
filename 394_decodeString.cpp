// Time Complexity : O(K*N) where K is the number of times the character repeated and N is the number of characters.
// Space Complexity :O(K*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    string decodeString(string s) {
        if(s.empty() || s.length() == 0)
            return s;
        int num=0;
        string currString;
        stack<int> numStack;
        stack<string> strStack;
        for(int i=0; i<s.length(); i++){
            char c = s[i];
            if(isdigit(c)){
                num = num*10 + (c - '0');
            }
            else if(c == '['){
                numStack.push(num);
                strStack.push(currString);
                num = 0;
                currString = "";
                
            }
            else if(c == ']'){
                int times = numStack.top();
                numStack.pop();
                string str;
                for(int j=0; j<times; j++){
                    str.append(currString);
                }
                currString = strStack.top() + str;
                strStack.pop();
            }
            else{
                currString += c;
            }
                
        }
        return currString;
    }
};

//recursion
class Solution {
public:
    int i;
    string decodeString(string s) {
        if(s.empty() || s.length() == 0)
            return s;
        int num=0;
        string currString;
        while(i<s.length()){
            char c = s[i];
            i++;
            if(isdigit(c)){
                num = num*10 + (c - '0');
            }
            else if(c == '['){
                string child = decodeString(s);
                string str;
                for(int j=0; j<num; j++){
                    str += child;
                }
                currString += str;
                num = 0;
            }
            else if(c == ']'){
                return currString;
            }
            else{
                currString += c;
            }
                
        }
        return currString;
    }
};
