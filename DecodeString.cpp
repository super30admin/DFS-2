// Time Complexity : O(Largest_Number * length_of_input_string)
// Space Complexity : O(n) where n = length of i/p string
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
/* Solve the problem recursively by decoding nested strings first.
 * Repeat the following operation till the global pointer i reaches to end of i/p string.
 *      If current char is digit then use the digit to form a number (current number).
 *      If current char is opening bracket then call the decode string method recursively. Add the string returned by the recursive method, current_number of 
 *      times to the answer (current string).
 *      If current char is closing bracket then simply returned the current string.
 */

class Solution {
public:
    int i = 0;
    string decodeString(string s) {
        if (s.empty())
            return "";
        
        int currNum = 0;
        string currStr = "";
        
        while (i < s.size())
        {
            char c = s[i];
            
            if (isdigit(c))
            {
                currNum = currNum * 10 + (c - '0');
                i++;
            }
            else if (c == '[')
            {
                i++;
                string decoded = decodeString(s);
                string newString = "";
                for (int j = 0; j < currNum; j++)
                {
                    newString += decoded; 
                }
                currStr += newString;
                currNum = 0;
            }
            else if (c == ']')
            {                
                i++;
                return currStr;
            }
            else
            {
                i++;
                currStr += c;
            }
        }
        return currStr;
    }
};