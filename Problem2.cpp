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
    string decodeString(string s) {
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
};