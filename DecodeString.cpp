// Approach - Iterative Solution.
// Time Complexity - O(length of the output string)
// Space Complexity - O(h) - "h" is the depth of the stack which is of the order of number of open brackets in the input.
// It runs on Leetcode!
// Problems Faced - No! 
class Solution {
public:
    string decodeString(string s) {
        stack<string> strSt;
        stack<int> numSt;
        
        string currStr = "";
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s[i];
            if(isdigit(c)){
                num = num*10 + c - '0';
            }
            else if(c == '['){
                numSt.push(num);
                strSt.push(currStr);
                currStr = "";
                num = 0;
            }
            else if(c == ']'){
                int k = numSt.top(); numSt.pop();
                string temp = "";
                for(int j = 0; j < k; j++){
                    temp += currStr;
                }
                string parent = strSt.top(); strSt.pop();
                currStr = parent + temp;
            }
            else{
                currStr += c;
            }
        }
        return currStr;
    }
};

// Approach - Recursive Solution.
// Time Complexity - O(length of the output string)
// Space Complexity - O(h) - "h" is the depth of the recursive stack which is of the order of number of open brackets in the input.
// It runs on Leetcode!
// Problems Faced - No! 
class Solution {
    int i = 0;
public:
    string decodeString(string s) {
        int n = s.length();
        
        string currStr = "";
        int currNum = 0;
        while(i < n){
            char curr = s[i];
            if(isdigit(curr)){
                currNum = currNum*10 + curr - '0';
                i++;
            }
            else if(curr == '['){
                i++;
                string decoded = decodeString(s);
                for(int j = 0; j < currNum; j++){
                    currStr += decoded;
                }
                currNum = 0; // This step is essential for test-cases like: "2[a2[c3[de]]]z2[bc]". However, if the input was of the form: 2[a2[c3[de]]] then resetting currNum was not needed here.
            }
            else if(curr == ']'){
                i++;
                return currStr;
            }
            else{
                currStr += curr;
                i++;
            }
        }
        return currStr;
    }
};