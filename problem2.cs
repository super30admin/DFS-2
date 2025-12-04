public class Solution {
    public string DecodeString(string s) {
        int currentNumber = 0;
        string currentString = "";
        Stack<int> numberStack = new Stack<int>();
        Stack<string> strStack = new Stack<string>();
        for(var i=0;i<s.Length;i++)
        {
            var currChar = s[i];
            if(char.IsDigit(currChar))
            {
                int num = currChar - '0';
                currentNumber = (currentNumber*10) + num;
            }
            if(char.IsLetter(currChar))
            {
                currentString = currentString + currChar;
            }
            if(currChar == '[')
            {
                strStack.Push(currentString);
                numberStack.Push(currentNumber);
                currentNumber = 0;
                currentString = "";
            }
            if(currChar == ']')
            {
                int curNumber = numberStack.Pop();
                string tmp = "";
                for(var j=0;j<curNumber;j++)
                {
                    tmp = tmp + currentString;
                }
                string curStr = strStack.Pop();
                currentString = curStr+tmp;
            }

        }
        return currentString;
    }
}