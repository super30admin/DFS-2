// Apporach 1 : BFS
// Time Complexity : O(size of output) .... output is maximum multiplier in input and total number of characters 
// Space Complexity : O(size of output)
//
/*
Leetcode : https://leetcode.com/problems/decode-string/description/

Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does
not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
The test cases are generated so that the length of the output will never exceed 105.
*/

/**
 * Refer : https://www.youtube.com/watch?v=bopuu6-6Rl8
*/

class Solution {
public:
    string decodeString(string s) {
        stack <int> num;
        stack <std::string> st;
        string currentString = "";
        int currentNum = 0;

        for(int i = 0; i < s.size(); i++){
            char ch = s[i];

            if(ch >= '0' && ch <= '9'){
                currentNum = currentNum*10 + ch - '0';
            } else if(ch == '['){
                st.push(currentString);
                num.push(currentNum);
                currentString = "";
                currentNum = 0;
            } else if(ch == ']'){
                int tempNum = num.top();
                num.pop();
                string storeSting = "";
                while(tempNum > 0){
                    storeSting += currentString;
                    tempNum--;
                    cout << storeSting << std::endl;
                }
                string tempString = st.top();
                st.pop();
                currentString = tempString + storeSting;
            } else {
                currentString += ch;
            }
        }
        return currentString;
    }
};