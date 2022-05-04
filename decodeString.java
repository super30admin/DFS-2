//TC : O(length of resulting string) SC : O(D)
class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> sStack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        int size=s.length();
        int num = 0;
        for(int i=0;i<size;i++)
        {
            char c = s.charAt(i);

            if(Character.isDigit(c))
            {
                num = num*10 + (c-'0');
            }
            else if(c=='[')
            {
                numStack.push(num);
                sStack.push(sb);
                num=0;
                sb=new StringBuilder();
            }
            else if(c==']')
            {
                int count = numStack.pop();
                StringBuilder sbTemp = new StringBuilder();
                for(int j=0;j<count;j++)
                {
                    sbTemp.append(sb);
                }
                sb = sStack.pop().append(sbTemp);
            }
            else
            {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}