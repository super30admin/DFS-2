//TC:O(n)
//SC:O(n)
//Successfully ran on leetcode
//Recursion based approach
class Solution {
    int i;
    public String decodeString(String s)
    {
        if(s==null || s.length()==0)
            return s;
        int num=0;
        StringBuilder currStr=new StringBuilder();
        while(i<s.length())
        {
            char c=s.charAt(i);
            if(Character.isDigit(c))
            {
                num=num*10+c-'0';
                i++;
            }
            else if(c=='[')
            {
                i++;
                String decoded=decodeString(s);
                StringBuilder newStr=new StringBuilder();
                for(int k=0;k<num;k++)
                {
                    newStr.append(decoded);
                }
                currStr.append(newStr);
                num=0;
            }
            else if(c==']')
            {
                i++;
                return currStr.toString();
            }
            else
            {
                currStr.append(c);
                i++;
            }
        }
        return currStr.toString();
    }
}
