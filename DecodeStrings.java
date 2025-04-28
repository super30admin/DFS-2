// Time Complexity : O(maxK × n)
// Space Complexity :O(maxK × n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


/*
This code decodes an encoded string where patterns like "3[a2[c]]" need to be expanded.
 It uses recursion to handle nested brackets, ensuring that inner parts are processed
 before outer ones. The variable currNum keeps track of how many times a substring should
 be repeated. When a [ is encountered, a recursive call is made to decode the substring
 inside the brackets.
The final answer is built by appending decoded parts and returned once the corresponding ] is reached.
* */

public class DecodeStrings {
    public String decodeString(String s) {
        //when solving manually as well
        //child needs to process first
        //recursion or stack
        int currNum=0;
        StringBuilder ans=new StringBuilder();

        while(i<s.length()){
            char c=s.charAt(i);
            i++;

            //sequence of else if does not matter
            if(c=='[')
            {
                String temp=decodeString(s);
                for(int k=0;k<currNum;k++)
                {
                    ans.append(temp);
                }
                currNum=0;
            }
            else if(Character.isDigit(c))
            {
                currNum=currNum*10 + c - '0' ;
            }
            else if(Character.isLetter(c))
            {
                ans.append(c);
            }
            else if(c==']')
            {
                return ans.toString();
            }

        }

        return ans.toString();

    }
}
