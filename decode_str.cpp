//TC: O(max value of k * n), where n is length of string
//SC: O(n + s) , where n is number of digits, s is number of characters.

class Solution {
public:
    string decodeString(string s) {
        
        //2 stacks for count, string
        stack<int> countStack;
        stack<string> stringStack;
        
        //initialize string to empty
        string currentString="";
        
        int k = 0;
        
        //iterate over string
        for(int i=0; i<s.length(); i++){
            char ch = s[i];
            //if the character is a number, then add it to k. If multiple digits, then multiply by 10 everytime.
            if(ch-'0' >=0 && ch-'0'<=9){
                k = k*10 + ch-'0';
            }
            else if(ch == '['){
                //if character is opening bracket, add number to the stack and reset the k. push the current string (will be empty when called for the first time), and reset the current string.
                countStack.push(k); k = 0;
                //push the current current string to the stringStack and reset this.
                stringStack.push(currentString);
                currentString = "";
            } 
            else if(ch == ']'){
                //pop the  top of the stringStack and add this  countStack*currentString times to decoded string
                int countChars = countStack.top();
                countStack.pop();
                string decoded = stringStack.top();
                stringStack.pop();
                
                //add the current string to the last added value in the stack string(which was obtained from the top of the stack). 
                for(int i=0; i<countChars; i++){
                    decoded += currentString;
                }
                
                //assign the decoded string to the new currentstring.
                currentString = decoded;
            }
            else {
                //add to the current string.
                currentString += ch;
            }
            
        }
        
        return currentString;
        
    }
};