// Time Complexity : O(N)  
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes 


// Your code here along with comments explaining your approach:
// 1. Maintain stacks to backtrack the parent string and repetition of the parent.
// 2. Use current string="" and current number=0. if we get any of those concatenate it to current ones.
// 3. If we get '[' push current values to stack and reset it. If we get ']' repete current string with top number in stack and concatenate to current string.

class Solution {
public:
    string sg(string s,int tr){
        string tre="";
        while(tr){
            tre=tre+s;
            tr--;
        }
        return tre;
    }
    string decodeString(string s) {
        stack<string> a;
        stack<int> n;
        int cn=0;
        string cs="";
        for(int i=0;i<s.size();i++){
            if(s[i]>='0' && s[i]<='9'){
                cn=cn*10+(s[i]-'0');
            }else if(s[i]=='['){
                n.push(cn);a.push(cs);cn=0;cs="";
            }else if(s[i]>='a' && s[i]<='z'){
                cs=cs+s[i];
            }else if(s[i]==']'){
                cs=a.top()+sg(cs,n.top());
                n.pop();a.pop();
            }
        }
        return cs;
    }
};
