package DFS2;
// Time Complexity : O(Kl)  -> k is the product of the numbers in the input string & l is the length of the input string
// Space Complexity : O(Kl)
// Did this code successfully run on Leetcode : Yes
public class DecodeStringUsingRecursion {
    int i;
    public String decodeString(String s) {

        int curNum = 0;
        StringBuilder curStr = new StringBuilder();

        while(i<s.length())
        {
            Character c = s.charAt(i);
            i++;
            if(Character.isDigit(c))
            {
                curNum = curNum *10 + c - '0';
            }
            else if(c == '[')
            {
                String temp = decodeString(s);
                for(int k=0; k<curNum; k++)
                {
                    curStr.append(temp);
                }
                curNum = 0;
            }
            else if(c == ']')
            {
                return curStr.toString();
            }
            else{
                curStr.append(c);
            }
        }
        return curStr.toString();
    }
}
