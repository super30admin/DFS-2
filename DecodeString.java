/*
This approach to solve the problem uses a DFS technique using a helper function. We have 4 rules when processing the string:
1. If a digit is the current character, then we record its numeric value.
2. If a letter is the current character, we append it to the result string.
3. If an opening bracket is the current character, we keep note of the numeric value and result string upto that bracket, and 
then recursively call the function to process the substring inside the bracket. Substring is processed with the same 4 rules.
4. If a closing bracket is the current character, we then come out of the recursive stack and return the substring created so 
far. We will then apply the numeric value multiplier to the returned substring, and append it to the current resultant string.

Did this code run on Leetcode: Yes
*/
class Solution {
    int i;
    //Time Complexity: O(n), n = length of result string
    //Space Complexity: O(n), n = number of brackets(because this will determine the recursive stack size)
    public String decodeString(String s) {
        
        
        StringBuilder str = dfs(s);
        
        return str.toString();
        
    }
    //We use StringBuilder instead of String to optimise the space, so that we do not have to create a new String at each append
    private StringBuilder dfs(String s)
    {
        StringBuilder str = new StringBuilder();
        int num = 0;
        
        
        while(i < s.length())
        {   
            char c = s.charAt(i);
            
            if(Character.isDigit(c))
            {
                num = num * 10 + c - '0';
                i++;
            }
            else if(c == '[')
            {
                i++;
                StringBuilder newStr = dfs(s);

                for(int j = 0; j < num; j++)
                {
                    str.append(newStr);
                }
                
                num = 0;
            }
            else if(c == ']')
            {
                i++;
                return str;
            }
            else
            {
                str.append(c);
                i++;
            }
        }
        return str;
    }
}