// Time Complexity : O(kxl)  k: Multiplication of all the numbers  l: length of the string
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//Here we will keep a pointer on the first character of the string. If we get a number, we add it to a variable currNum, else if we get an alphabet, we add it to a variable CurrString. 
//If we get an opening bracket, we push the elements in currNum and CurrString to two stacks NumStack and StringStack respectively. When we get a closing bracket, we need to pop the number in the numstack. 
//The string in the CurrString needs to be printed as many times as the popped number. Then concatenate that with the first string in the StringStack. We need to keep repeating this until we reach the end of the string


class Solution {
    public String decodeString(String s) {
        
        StringBuilder currStr=new StringBuilder();
        int currNum=0;
        Stack<StringBuilder> StringStack=new Stack<>();
        Stack<Integer> NumStack=new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);

            //If the character is a digit
            if(Character.isDigit(c))
            {
                currNum=currNum*10+ c-'0'; //Here we are subtracting the number with its ascii value
            }

            //If the character is an opening bracket
            else if(c=='[')
            {
                //We push the elements from CurrNum and CurrString to their respective stacks
                NumStack.push(currNum);
                StringStack.push(currStr);

                //update the values
                currStr= new StringBuilder();
                currNum=0;
            }

            //If the character is a closing bracket
            else if(c==']')
            {
                //we pop the num from the numstack
                int cnt=NumStack.pop();
                StringBuilder baby=new StringBuilder();

                //we need the string in currString to be printed as many times as the popped number
                for(int k=0;k<cnt;k++)
                {
                    baby.append(currStr);
                }

                //then we append it to the parent in the StringStack
                StringBuilder parent=StringStack.pop();
                currStr=parent.append(baby);
            }

            //If the character is an alphabet
            else
            {
                //We append it to the currStr
                currStr.append(c);
            }

        }

        return currStr.toString();
    }
}