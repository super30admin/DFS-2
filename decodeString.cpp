/*
Intuition: Always process of the inner brackets first.

Think of the different characters: [,],0-9,a-z
Time Complexity: O(N) where N = number of characters
Space Complexity: O(N) where N = number of characters or Depth of the inner most brackets
*/


class Solution {
public:
    string decodeString(string s) {
        
        string currentString;
        int num = 0;
        
        stack <int> numStack;
        stack <string> stringStack;
        
        for ( int i = 0; i < s.size(); i ++){
            char c = s[i];
            
            if (isdigit(c)){
                
                num = num * 10 + c - '0';
                
            }
            else if (c == '['){
                numStack.push(num);
                stringStack.push(currentString);
                num = 0;
                currentString = "";
                
            }
            else if (c == ']'){
                
                int times = numStack.top();
                numStack.pop();
                
                string newString;
                for (int j = 0; j < times; j++ ){
                    newString += currentString;
                }
                string newString1 = stringStack.top();
                stringStack.pop();
                currentString = newString1 + newString;
            
            }
            else{
                currentString += c;
                
            }
        
        
        }

        return currentString;
    }
};