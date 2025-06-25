#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    int i=0;
    string decodeString(string s) {
        int num = 0;
        string curr;
        while(i < s.length()) {
            char ch = s[i];
            i++;
            if(isdigit(ch)) {
                num = num * 10 + (ch - '0');
            } 
            else if(ch == '[') {
                string str = decodeString(s);
                for(int j = 0; j < num; j++) {
                    curr += str;
                }
                num = 0;
            } 
            else if(ch == ']') {
                return curr;
            } else {
                curr += ch;
            }
        }

        return curr;
    }
};