// Time Complexity : O(decodestring-length)
// Space Complexity : O(decodestring-length)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class Solution {
    public string DecodeString(string s) {
        Stack<int> numSt = new Stack<int>();
        Stack<string> strSt = new Stack<string>();
        int currNum = 0;
        string currStr = "";
        for(int i = 0; i < s.Length; i++)
        {
            var ch = s[i];            
            if(Char.IsDigit(ch)){
                currNum = currNum * 10  + ch - '0';                
            }
            else if(ch == '[')
            {                
                numSt.Push(currNum);
                strSt.Push(currStr);
                currNum = 0;
                currStr = "";
            }
            else if(ch == ']'){                
                var count = numSt.Pop();                  
                var child = "";             
                for(int k = 0; k < count; k++){
                    child = child + currStr;
                }              
                currStr = strSt.Pop() + child;                
            }else{
               currStr =  currStr + ch;
            }
        }
        return currStr;
    }
}
