#include <stack>
#include <string>
#include <iostream>
#include <vector>
using namespace std;
bool isDigit( char c ){
    return c>='0'&&c<='9';
}
string decodeString(string s) {
    string finalExpanded;
    stack<string>repeatedSubStr,repeatedSubStrCounts;
    int n = s.size();
    for(int i=0;i<=n-1;i++){
        if(isDigit(s[i])){
            if(i==0||!isDigit(s[i-1])){
                repeatedSubStrCounts.push("");
            }
            repeatedSubStrCounts.top().push_back(s[i]);                
        }
        else if(s[i]=='['){
            repeatedSubStr.push("");
        }
        else if(s[i]==']'){
            int repCount = stoi(repeatedSubStrCounts.top());
            repeatedSubStrCounts.pop();
            string subStr = repeatedSubStr.top();
            repeatedSubStr.pop();
            string expanded;
            
            for(int t=1;t<=repCount;t++) expanded.insert(expanded.end(),subStr.begin(),subStr.end());
            if(repeatedSubStrCounts.empty()){
                finalExpanded.insert(finalExpanded.end(),expanded.begin(),expanded.end());
            }
            else{
                repeatedSubStr.top().insert(repeatedSubStr.top().end(),expanded.begin(),expanded.end());
            }
        }
        else{
            if(repeatedSubStrCounts.empty()){
                finalExpanded.push_back(s[i]);
            }
            else{
                repeatedSubStr.top().push_back(s[i]);
            }
        }
    }
    return finalExpanded;
}
int main() {
    string s = "3[a2[c]]";
    string result = decodeString(s);
    cout << "Decoded string: " << result << endl; // Output: accaccacc
    return 0;
}
// // Time Complexity: O(n)
// // Space Complexity: O(n) in the worst case, where n is the length of the input string
// // Did this code successfully run on Leetcode: Yes
// // Any problem you faced while coding this: No
// // Your code here along with comments explaining your approach in three sentences only
// Used 2 stacks to collect the repeated substrings and their counts, and then expanded the substrings when we encounter a closing bracket.
// The final expanded string is built by appending the expanded substrings to the final result or to the top of the repeated substring stack.