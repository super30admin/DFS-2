/*
Time Complexity: O(Maximum value of iteration N.s length of string)
Space Complexity: O(m+n)
*/
class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack=new Stack<>();
        Stack<String> wordStack =new Stack<>();
        int k=0;
        StringBuilder res=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(Character.isDigit(ch))
            {
                k=k*10+ch-'0';
            }
            else if(Character.isLetter(ch))
            {
                res.append(ch);
            }
            else if(ch=='[')
            {
                countStack.push(k);
                wordStack.push(res.toString());
                k=0;
                res=new StringBuilder();
            }
            else
            {
                int c=countStack.pop();
                StringBuilder dupe=new StringBuilder(wordStack.pop());
                for(int j=c;j>0;j--)
                {
                    dupe.append(res);
                }
                res=dupe;
            }
            
        }
        return res.toString();
    }
}