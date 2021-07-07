// 394.

//time - O(length of output string)
//space - O(n) - n length of input string
class Solution {
    public String decodeString(String s) {
        //edge
        if(s == null || s.length() == 0)
        {
            return s;
        }
        
        int currentNumber = 0;
        String currentString = "";
        
        Stack<Integer> numbers = new Stack<>();
        Stack<String> strings = new Stack<>();
        
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) //current char is number
            {
                currentNumber = (currentNumber * 10) + (ch - '0'); //update current number
            }
            else if(Character.isLetter(ch)) //current char is a letter
            {
                currentString = currentString + ch; //update current string
            }
            else if(ch == '[')
            {
                //push current variables into stack and reset
                numbers.push(currentNumber);
                strings.push(currentString);
                
                currentNumber = 0;
                currentString = "";
            }
            else //closing bracket
            {
                //multiply current string by number from stack top of numbers
                //append that answer to stack top of strings and make that current string
                int prefix = numbers.pop();
                StringBuilder answer = new StringBuilder();
                while(prefix > 0)
                {
                    answer.append(currentString);
                    prefix--;
                }
                currentString = strings.pop() + answer.toString();
            }
        }
        
        return currentString;
    }
}
