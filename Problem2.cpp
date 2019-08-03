//
// Created by shazm on 8/2/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

// Runtime: O(n)
// Space: O(n)
// Approach: Use two stacks, one for the integer values, and one for the characters, whenever you encounter ']' calculate
// a new string with the updated decoded string and repeat till end of string to be decoded.

using namespace std;

class Solution{
public:
    string decodeString(string s) {  //simpler and avoids edge cases.
        if(s == ""){return "";}

        stack<int> integer;
        stack<char> characters;
        string tempstr = ""; string inte = "";
        for(int x = 0; x<s.size(); x++){
            if(isdigit(s[x])){
                inte += s[x];
                if(x+1<s.size() && !isdigit(s[x+1])){
                    integer.push(stoi(inte)); inte = "";
                }
            }else if(s[x]!=']'){
                characters.push(s[x]);
            }else{
                int inttop = integer.top(); integer.pop();
                tempstr = "";
                while(characters.top()!='['){
                    tempstr = characters.top()+tempstr;
                    characters.pop();
                }
                if(characters.top()=='['){characters.pop();}
                string add = tempstr;
                for(int i = 1; i<inttop; i++){
                    tempstr+=add;
                }
                for(char c : tempstr){
                    characters.push(c);
                }
            }
        }
        tempstr = "";
        while(!characters.empty()){
            tempstr = characters.top()+tempstr;
            characters.pop();
        }
        return tempstr;
    }

    string decodeString(string s) { // a little faster.
        if(s==""){return "";}

        stack<int> integer;
        stack<string> str;
        str.push("");

        string inte = ""; string alp = "";
        for(int x = 0; x<s.size(); x++){
            if(isdigit(s[x])){
                inte += s[x];
                if(x+1<s.size() && !isdigit(s[x+1])){
                    integer.push(stoi(inte)); inte = "";
                    str.push("");
                }
            }else if(isalpha(s[x])){
                alp += s[x];
                if((x+1<s.size() && !isalpha(s[x+1])) || x+1>=s.size()){
                    string stop = str.top(); str.pop();
                    str.push(stop+alp); alp = "";
                }
            }else if(s[x]==']'){
                int inttop = integer.top(); integer.pop();
                string strtop = str.top(); str.pop();
                string alpha = strtop;
                for(int i = 1; i<inttop; i++){
                    strtop = alpha +strtop;
                }
                alpha = str.top(); str.pop();
                str.push(alpha+strtop);
            }
        }
        return str.top();
    }
};