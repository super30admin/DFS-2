// Time complexity: O(n)
// Space complexity: O(n)
// Did this code successfully run on Leetcode : Yes

//Approach:
//1. We use 2 stacks, one for numbers and one for strings.
//2. If number, update current number by multiplying by 10 and adding the digit.
//3. If '[', push the current number and current string to their respective stacks and reset the current number and string.
//4. If ']', pop the number and string from their respective stacks and update the current string by appending the popped string 'number' times.
//5. If character, append it to the current string.
//6. Return the current string.

class Solution {
    public:
        string decodeString(string s) {
            stack<int> nums;
            stack<string> str; 
            string currStr = "";
            int currNum = 0; 
    
            for(int i = 0; i < s.size(); i++){
                char c = s[i];
                if(isdigit(c)){
                    currNum = currNum * 10 + c - '0';
                }
                else if(c == '['){
                    nums.push(currNum);
                    str.push(currStr);
                    currNum = 0; 
                    currStr = "";
                }
                else if(c == ']'){
                    int times = nums.top();
                    nums.pop();
                    string newStr = "";
                    for(int j = 0; j < times; j++){
                        newStr.append(currStr);
                    }
                    currStr = str.top();
                    str.pop();
                    currStr += newStr;
                }
                else{
                    currStr += c;
                }
            }
            return currStr; 
        }
    };