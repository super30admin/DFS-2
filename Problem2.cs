public class DecodeStrings
    {
        // Time Complexity : O(n) - where n is the length of the output string
        // Space Complexity : O(n) - for the stack 
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        public string DecodeString(string s)
        {
            Stack<int> numStack = new Stack<int>();
            Stack<StringBuilder> strStack = new Stack<StringBuilder>();
            int currNum = 0;
            StringBuilder currStr = new StringBuilder();
            for(int i = 0; i < s.Length; i++)
            {
                char c = s[i];
                if(Char.IsDigit(c))
                {
                    currNum = currNum * 10 + c - '0';
                }
                else if(c == '[')
                {
                    //push currNum to numstack and currStr to string stack
                    numStack.Push(currNum);
                    strStack.Push(currStr);
                    //reset currNum and currStr
                    currNum = 0;
                    currStr = new StringBuilder();
                }
                else if(c == ']')
                {
                    int count = numStack.Pop();
                    StringBuilder innerStr = new StringBuilder();
                    for(int j = 0; j < count; j++)
                    {
                        innerStr.Append(currStr);
                    }
                    currStr = strStack.Pop().Append(innerStr);


                }
                else //alphabets
                {
                    currStr.Append(c);
                }
            }
            return currStr.ToString();
        }
    }
