import java.util.Stack;

/*approach
 * 1. take two stacks for pushing number and string. take int num=0, and stringBuilder str = empty 
 * 2. traverse through the string and follow steps
 *  a. if character is a digit - num*10 + digit
 *  b. if character apeend it to existing string
 *  c. if'[' opening - 
 *          -- push num nd existing string to stacks
 *          -- reset num to zero and string = empty
 *  d.if ']' closign  - 
 *          -- temp - pop the num stack
 *          -- get a new string builder - just to get a looped string going seprately from curr str. 
 *          -- loop temp times and append the curr string to newstr
 *          -- currstr = newStr 
 * 
 *          --pop string stack - poppedstring.append(cuurstr)
 *  e. return currstring.toString();
 * 
 * TC - O(nk) - n characters - looped k times!
 * SC - depends on how much nesting there are in the string - O(Depth of the Tree/ Max Nesting available)
 */

class Solution {
    public String decodeString(String s) {
        if(s == null || s.length == 0) return s;

        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        int num =0;
        StringBuilder currStr = new StringBuilder();

        for(int i =0; i< s.length(); i++)
        {
            char c = s.charAt(c);
            
            if(Character.isDigit(c))
            {
                num = num*10 + (c - '0');
            }
            else if( c == '[')
            {
                  numStack.push(num);
                  strStack.push(currStr);
                  
                  //reset both pushed
                num =0;
                currStr = new StringBuilder();
            }
            else if(c == ']')
            {
                //pop num stack
                int temp  = numStack.pop();

                StringBuilder temp_str = new StringBuilder();
                //loop existing string temp times
                for (int j=0; j< temp; j++)
                {
                    temp_str.append(currStr);
                }
                currStr = temp_str;
            }
            else
            {
                //it's character
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}



