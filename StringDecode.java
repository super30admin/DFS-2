//Time complexity: O(n+no.of str values)
//Space :O(n)
//Executed on leetcode.

class Solution {
    public String decodeString(String s) {
           //On encounter of [ push the number and string to Stack
        Stack<Integer> staNum = new Stack<>();
        Stack<StringBuilder> staStr = new Stack<>();
        int currNum = 0;
        StringBuilder currStr = new StringBuilder();
        for(int i=0;i<s.length();i++)       //Has 2 stacks, 1 to store numbers and other to store substrings with actual string values.
        {
            if(s.charAt(i)-'0'<=9)
            {
                currNum = currNum*10+(s.charAt(i)-'0');//While the character at particular index is an integer, make it a number and on [ push the integer and till string to stacks.
            }
            else if(s.charAt(i)=='[')
            {
                staNum.push(currNum);   //on closed bracket, pop the integer from stack and get the current string value. 
                staStr.push(currStr);
                currNum = 0;
                currStr =  new StringBuilder("");
            }
            else if(s.charAt(i)==']')
            {
                StringBuilder temp = new StringBuilder();
                int num = staNum.pop();
                for(int j=0;j<num;j++)
                {
                    temp= temp.append(currStr);
                }
                currStr = staStr.pop().append(temp);
                
            }
            else
            {
                currStr = currStr.append(s.charAt(i));
            }
        }
        
        return currStr.toString();
    }    
   
}