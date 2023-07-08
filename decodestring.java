// Time Complexity : length of output string
// Space Complexity : Length of output string (it can be stored in a stack)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Understanding tc and sc

// Your code here along with comments explaining your approach:
// we are taking 2 stacks , one to store integer and other one to store string builders
//  a currst stringBuilder and currnum variable.
// we have 4 cases:
// 1) if we get a number :- we need to add it to the previous number 
// 2) if we get a [ then we push the currNum and curr string to the respective stacks and make them 0 and null again 
// 3) if we get a ] then we need to get the count by popping the num stack and repeat the currSt "Count" times and append this to the parent.
// we can find the parent by popping the string stack and make this appended string and Curr St.
// 4) the last case is if we get a character we append it directly to the curr string.

    class Solution {
    public String decodeString(String s) {
        Stack<Integer> numst = new Stack<>();
        Stack<StringBuilder> Strst = new Stack<>();
        StringBuilder currst= new StringBuilder();
        int currNum=0;
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                currNum = currNum*10 + c -'0';
            }
            else if(c=='[')
            {
                numst.push(currNum);
                Strst.push(currst);
                currst= new StringBuilder();
                currNum=0;

            }
            else if(c==']')
            {
                int count=numst.pop();
                StringBuilder baby = new StringBuilder();
                for(int j=0;j<count;j++)
                {
                    baby.append(currst);
                }
                StringBuilder parent = Strst.pop();
                parent.append(baby);
                System.out.println(parent);
                currst= parent;
            }
            else
            {
                currst.append(c);
            }
        }
        return currst.toString();
    }
}