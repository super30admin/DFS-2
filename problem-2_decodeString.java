// Time Complexity :
//      total time complexity will be O(n) where n is the length of the string
//
// Space Complexity :
//      O(n)->where n is the length of the string
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public String decodeString(String s) {
        if(s.length()==0)
            return "";
        String result="", substring="";
        int multiplier=0, num=0;
        char c;
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> integerStack = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            c = s.charAt(i);
            if(Character.isDigit(c))
            {
                num = num*10 + c - '0';
            }
            else if(c == '[')
            {
                integerStack.push(num);
                stringStack.push(substring);
                num = 0;
                substring = "";
            }
            else if(c==']')
            {
                multiplier = integerStack.pop();
                StringBuilder str = new StringBuilder();
                for(int j=0; j<multiplier;j++)
                {
                    str.append(substring);
                }
                substring = stringStack.pop();
                substring += str;
            }
            else
            {
                substring =  substring+c;
            }
        }
        return substring;
    }
}