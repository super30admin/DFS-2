// time complexity lenght of string
class Solution {
    public String decodeString(String s) {
        if(s==null || s.length()==0)
        {
            return"";
        }
        StringBuilder currString= new StringBuilder();
        int num=0;
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(Character.isDigit(c))
            {
                num=num*10+c-'0';
            }
            else if(c=='[')
            {
                numStack.push(num);
                strStack.push(currString);
                currString=new StringBuilder();
                num=0;
            }
            else if(c==']')
            {
                int times=numStack.pop();
                StringBuilder newString= new StringBuilder();
                for(int j=0;j<times;j++)
                {
                    newString.append(currString);
                }
                currString=strStack.pop().append(newString);
            }
            else
            {
                currString.append(c);
            }
        }
        return currString.toString();

    }
}