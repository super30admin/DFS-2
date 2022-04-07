// Time Complexity : O(max of k) * O(number of letters) k is number of times letters are repeated
// Space Complexity : O(length of input string)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
    public String decodeString(String s) {

        //iterative approach

        //maintain current string and current number
        StringBuilder current = new StringBuilder();
        int num = 0;

        //stacks for current number and string
        Stack<StringBuilder> strStack = new Stack();
        Stack<Integer> numStack = new Stack();

        //iterate over input
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);

            if(Character.isDigit(c))
                num = num*10 + c - '0'; //number could be 2 digit
            else if(c == '[') //internal string has to be combined with parent
            {
                //push in stack
                strStack.push(current);
                numStack.push(num);

                //reset them for inner child
                current = new StringBuilder();
                num = 0;
            }
            else if(c == ']') //current string has to be decoded using num and combined with parent
            {
                //num which will tell how many time we have to repeat
                int k = numStack.pop();
                StringBuilder decoded = new StringBuilder();
                for(int j=0; j<k; j++)
                    decoded.append(current);
                current = strStack.pop().append(decoded);
            }
            else //c is a letter
            {
                current.append(c);
            }
        }

        return current.toString();

    }
}
