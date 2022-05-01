// Time Complexity                              :  O(N) where N is the length of the string
// Space Complexity                             :  O(N) asymptotically. The sum of spaces in both the stacks combine to asymptotically equal to the number of elements in the string. 
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/decode-string/submissions/

class Solution {
private:
    string fstr(int n,string s) {
        string str = "";
        while(n--) {
            str += s;
        }
        
        return str;
    }

public:
    string decodeString(string s) {
        
        string ansI = iterative(s);
        return ansI;
        
    }
    
    // 2 stack approach
    string iterative(string s) {
        int n = s.size();
        if(n == 1) return s;
        
        stack<string> st1;
        stack<int> st2;
        
        string num = "";
        
        for(int i=0;i<n;i++) {
            
            if(s[i] >= '0' and s[i] <= '9') {
                num += s[i];
                continue;
            }
            
            if(num != "") {
                int nu = stoi(num);
                st2.push(nu);
                num = "";
            }
            
            if(s[i] == ']') {
                string str = "";
                int f = 0;
                while(st1.top() != "[") {
                    str = st1.top() + str;
                    st1.pop();
                }

                if(st1.top() == "[") {
                    f = st2.top();
                    st2.pop();
                    st1.pop();
                }

                if(f > 0 and str != "") {
                    string temp = fstr(f,str);
                    st1.push(temp);
                }
            } else {
                st1.push(string(1, s[i]));
            }

        } 
        
        string ans;
        while(!st1.empty()) {
            ans = st1.top() + ans;
            st1.pop();
        }
        
        return ans;
    }
};