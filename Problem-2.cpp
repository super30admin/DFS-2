// Time Complexity : O(N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using two stacks, keeping track of currStr and currNum,
// and updating them based on the chars in the string.

// 394. Decode string

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string decodeString(string s) {
        stack<int> numStk;
        stack<string> strStk;
        int n = s.length();
        string currStr = "";
        int currNum = 0;
        for(int i=0;i<n;i++){
            if(isdigit(s[i])){
                currNum = currNum*10+(s[i]-'0');
            }
            else if(s[i] == '['){
                strStk.push(currStr);
                numStk.push(currNum);
                currNum = 0;
                currStr = "";
            }
            else if(s[i] == ']'){
                string decoded = "";
                int k = numStk.top();
                numStk.pop();
                for(int j=0;j<k;j++){
                    decoded += currStr;
                }
                string parent = strStk.top();
                strStk.pop();
                currStr = parent + decoded;

            }
            else{
                currStr += s[i];
            }
        } 
        return currStr;
    }
};