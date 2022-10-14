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
    int i;
    public String decodeString(String s) {
        if(s == null || s.length == 0) return s;

        int num =0;
        StringBuilder currStr = new StringBuilder();

        while(i < s.length())
        {
            char c = s.charAt(c);
            
            if(Character.isDigit(c))
            {
                i++;
                num = num*10 + (c - '0');
            }
            else if( c == '[')
            {
                  String returned = decodeString(s);
                  StringBuilder temp_str = new StringBuilder();
                 //loop existing string temp times
                    for (int j=0; j< temp; j++)
                    {
                        temp_str.append(returned);
                    }
                    currStr = currStr.append(temp_str);
                  
                num =0;
            }
            else if(c == ']')
            {
                //pop num stack
                i++;
                return currStr.toString();
            }
            else
            {
                i++;
                //it's character
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}



//copied from what I wrote on Leetcode
//DFS approach

class Solution {
    int i;
    public String decodeString(String s) {
        
        //take num and stringbuilder as local variables
        int num =0; 
        StringBuilder curr_strb = new StringBuilder();
        
        while(i < s.length())
        {
            char c = s.charAt(i);
            
            if(Character.isDigit(c))
            {
                num=num*10+ (c - '0');
                i++;
            }
            else if(c == '[')
            {
                i++;
                //push operation to the stack - recursive call
                String returned_str = decodeString(s);
                
               // System.out.println("Returned - "+returned_str+ "  , Current  - "+curr_strb);
                //here we come back from the recursive call so pop operation
                // numstack num popped, and string popped from string stack
                
                StringBuilder temp = new StringBuilder();
                for(int j= 0 ; j < num; j++) //this num will be from the previously existing call
                {
                    temp.append(returned_str);
                }
                //popped string from the stack and then append the temp
                
                curr_strb.append(temp);
                
                //reset num and string builder -
                //string builder will automatically loose the scope, currStrb is set ,  and so just update the num 
                num =0;
                
            }
            else if(c == ']')
            {
                //pop from the stack
                i++;
                return curr_strb.toString();
            }
            else
            {
                i++;
                //it's character, just append it to the string
                curr_strb.append(c);
            }
        }
        return curr_strb.toString();
    }
}