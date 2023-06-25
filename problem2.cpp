/*

// Time Complexity : product of all the integers * string characters
// Space Complexity : output length
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
Store the the current number and current string. 
if number encountered store it in the number
if string encountered append it into the string
if [ encountered push all the number and string in their respective stack and initialize them to 0
if ] encountered pop the number , duplicate the current string by the amount of number
Pop the previous string and append the new string into it.
Do it until the end of the string.

*/



#include<iostream>
#include<cstring>
#include<string>
#include<stack>
#include<cctype>

using namespace std;

class Solution {
public:
    string decodeString(string s) {
        stack<int> st1;
        stack<string> st2;
        int curr_num{};
        string curr_string{};
        for(auto& c:s){
            if(isalpha(c)){
                curr_string = curr_string + c;
            }
            else if(isdigit(c)){
                curr_num = curr_num*10+c-'0';
            }
            else if(c == '['){
                st1.push(curr_num);
                curr_num = 0;
                st2.push(curr_string);
                curr_string = "";
            }
            else if(c == ']'){
                int n = st1.top();
                st1.pop();
                string new_string{};
                for(int i{};i<n;++i) new_string = new_string + curr_string;
                curr_string = st2.top();
                st2.pop();
                curr_string = curr_string+new_string;
            }
        }
        return curr_string;
    }
};