#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We start with a current number and current stirng and when we encounter a opening [
we recall the fucntion to get the number of times the letters has to print
and then we return the current string 
*/
class Solution{
public:
    int i = 0;
    string decodeString(string s){
        int currNum = 0;
        string currStr;

        while(i<s.length()){
            char c = s[i];
            i++;

            if(isdigit(c)) currNum = currNum*10 + (c-'0');
            else if(c == '['){
                string baby = decodeString(s);
                for(int k=0; k<currNum; k++){
                    currStr += baby;
                }
                currNum = 0;
            }
            else if(c == ']') return currStr;
            else currStr += c;
        }
        return currStr;
    }

};
