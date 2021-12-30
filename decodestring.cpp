//Time complexity : O(n * maxNumInTheString)
//Space complexity : O(n)

//Approach :
            //Keep track of every number before encountering [
            //Keep track of all the characters
            //If [ is encountered, push current number and current string to stack
            //If ] is encountered, pop both number and string, also append the current string num times
            //Update currentString to popped string to above created string
            //Return currentString

class Solution {
public:
    string decodeString(string s) {
        if(s.size() == 0)
            return "";
        
        stack<int> intStack;
        stack<string> strStack;
        int num = 0;
        string currStr = string("");
        for(int i = 0 ; i < s.size() ; i++)
        {
            if(isdigit(s[i]))
            {
                num = num * 10 + s[i] - '0';
            }
            else if(s[i] == '[')
            {
                intStack.push(num);
                strStack.push(currStr);
                currStr = string("");
                num = 0;
            }
            else if(s[i] == ']')
            {
                int times = intStack.top();
                intStack.pop();
                string str = string("");
                for(int j = 0 ; j < times; j++)
                {
                    str += currStr;
                }
                currStr = strStack.top() + str;
                strStack.pop();
            }
            else
            {
                currStr += s[i];
            }             
        }
        
        return currStr;
    }
};